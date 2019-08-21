#!/usr/bin/env groovy

def call(String sonarScanner, String sonarServerName){
    withSonarQubeEnv(sonarServerName) {
        sh "${sonarScanner}bin/sonar-scanner" 
    }
}
