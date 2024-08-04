package com.bootlabs

/**
 * This class holds constants
 */
class Constants {
  
   // Stages 
   static final String MVN_BUILD = ">>> Maven Build Stage: clean instal"
   static final String MVN_TEST = ">>> Maven Running Tests Stage: clean test-compile"
   static final String MVN_IT = ">>> Maven Integration testing Stage: clean verify"
   static final String MVN_OWASP = ">>> Maven OWASP Dependency-Check Vulnerabilities"
   static final String MVN_SONAR = ">>> Running sonar Analysis"
   static final String DOCKER_CONTAINER_CLEAN = ">>> Cleaning docker container and inages"
   static final String DOCKER_CONTAINER_START = ">>> Running docker container"
   static final String SETUP_ENV = "Setup Environment"
   static final String BUILD_PACK = "Build the pack"
   static final String BUILD_IMAGE = "Build the immutable image"
   static final String DEPLOY_DEV = "Deploy to Development"
   static final String APPROVE_STAGING = "Approve Staging"
   static final String DEPLOY_STAGING = "Deploy to Staging"
   static final String RUNNING_TESTS = "Running Tests"
   static final String APPROVE_PRODUCTION = "Approve Production"
   static final String DEPLOY_PRODUCTION = "Deploy to Production"

   // Jenkins env name  
   static final String MVN_ENV = "MAVEN_ENV"
}