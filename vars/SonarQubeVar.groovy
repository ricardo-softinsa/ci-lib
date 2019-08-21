#!/usr/bin/env groovy

def call(){
    withSonarQubeEnv(sonarServerName) {
        sh "scannerName/bin/sonar-scanner" 
    }
}
