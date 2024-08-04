#!/bin/groovy

import com.bootlabs.MavenLifecycle
import com.bootlabs.Constants

def call(Map buildParams) {

    def mvn = new MavenLifecycle()


    pipeline {
        agent any

        options {
            // Keep the 10 most recent builds
            buildDiscarder(logRotator(numToKeepStr: '25'))
            timeout(time: 10, unit: 'MINUTES')
            ansiColor('xterm')
            timestamps()
        }

        stages {

            stage('Build') {
                steps {
                    script {
                        log.info Constants.MVN_BUILD
                        
                        mvn.mavenBuildGoal(buildParams.mvnBuildArgs)
                    }
                }
            }

            stage('Unit tests') {
                steps {
                    script {
                        log.info Constants.MVN_TEST

                        mvn.mavenTestGoal(buildParams.mvnTestArgs)
                    }
                }
            }

            stage('Integration tests') {
                steps {
                    script {
                        log.info Constants.MVN_IT
                        
                        mvn.mavenIntegrationTestGoal(buildParams.mvnITArgs)
                    }
                }
                post {
                    success {
                        junit allowEmptyResults: true, testResults: '**/*-reports/*.xml'
                    }
                }
            }

            stage('Code quality - sonar') {
                steps {
                 script {
                        log.info Constants.MVN_SONAR
                    }
                }
            }

            stage('OWASP Dependency-Check Vulnerabilities') {
                steps {
                 script {
                        log.info Constants.MVN_OWASP
                    }
                }
            }
        }
    }

}
