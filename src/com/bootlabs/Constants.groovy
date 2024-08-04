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

   // Jenkins env name  
   static final String MVN_ENV = "MAVEN_ENV"
}