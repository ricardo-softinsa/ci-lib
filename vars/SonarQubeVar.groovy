#!/usr/bin/env groovy

def sonarAnalysis(String sonarScanner, String sonarServerName){
    withSonarQubeEnv(sonarServerName) {
        sh "${sonarScanner}/bin/sonar-scanner" 
    }
}
