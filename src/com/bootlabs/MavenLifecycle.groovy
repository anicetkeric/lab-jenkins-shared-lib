package com.bootlabs


def mavenBuildGoal(String opts) {
    mvnRunCommand("clean install ${opts}")
}

def mavenTestGoal(String opts) {
    mvnRunCommand("clean test-compile ${opts}")
}

def mavenIntegrationTestGoal(String opts) {
    mvnRunCommand("clean verify ${opts}")
}


def mvnRunCommand(String command) {
    withMaven(maven: Constants.MVN_ENV) {
        sh "mvn ${command}"
    }
}
