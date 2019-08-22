#!/usr/bin/env groovy

def sonarAnalysis(String sonarScanner, String sonarServerName){
    withSonarQubeEnv(sonarServerName) {
        sh "${sonarScanner}/bin/sonar-scanner" 
    }
}

def qualityGates(){
    timeout(time: 1, unit: 'MINUTES') { // Just in case something goes wrong, pipeline will be killed after a timeout
        def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
            if (qg.status != 'OK') {
                error "Pipeline aborted due to quality gate failure: ${qg.status}"
        }
    }
}