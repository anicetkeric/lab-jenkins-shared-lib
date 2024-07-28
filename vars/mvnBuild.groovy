#!/bin/groovy

def call(Map buildParams) {
    pipeline {
        agent any

        options {
            buildDiscarder(logRotator(numToKeepStr: '25'))
            timeout(time: 10, unit: 'MINUTES')
            ansiColor('xterm')
            timestamps()
        }

        environment {
            MAVEN_BUILD_ARGS = buildParams.mvnBuildArgs
            MAVEN_UNIT_TEST_ARGS = buildParams.mvnTestArgs
            MAVEN_IT_ARGS = buildParams.mvnITArgs
        }

        stages {

            stage('Build') {
                steps {
                    withMaven(maven: 'MAVEN_ENV') {
                        sh "mvn clean install ${MAVEN_BUILD_ARGS}"
                    }
                }
            }

            stage('Unit tests') {
                steps {
                    withMaven(maven: 'MAVEN_ENV') {
                        sh "mvn clean test-compile ${MAVEN_UNIT_TEST_ARGS}"
                    }
                }
            }

            stage('Integration tests') {
                steps {
                    withMaven(maven: 'MAVEN_ENV') {
                        sh "mvn clean verify ${MAVEN_IT_ARGS}"
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
                    sh """
                    echo "Running sonar Analysis"
                """
                }
            }

            stage('OWASP Dependency-Check Vulnerabilities') {
                steps {
                    sh """
                echo "OWASP Dependency-Check Vulnerabilities"
                """
                }
            }
        }
    }

}