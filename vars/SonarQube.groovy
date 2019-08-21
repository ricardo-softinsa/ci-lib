#!/usr/bin/env groovy

def sonarAnalysis(scannerName, sonarServerName){
    withSonarQubeEnv(sonarServerName) {
        sh "scannerName/bin/sonar-scanner" 
    }
}