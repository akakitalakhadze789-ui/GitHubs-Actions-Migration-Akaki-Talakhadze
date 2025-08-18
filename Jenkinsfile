@Library('jenkins-shared-library@main') _

pipeline {
    agent any

    stages {
        stage('Prepare') {
            steps {
                script {
                    runId = pipelineUtils.prepareRun()
                }
            }
        }

        stage('Parallel Jobs') {
            parallel {
                stage('Job A') {
                    steps {
                        script { pipelineUtils.runJob('JobA') }
                    }
                }
                stage('Job B') {
                    steps {
                        script { pipelineUtils.runJob('JobB') }
                    }
                }
                stage('Job C') {
                    steps {
                        script { pipelineUtils.runJob('JobC') }
                    }
                }
            }
        }

        stage('Integration') {
            steps {
                script {
                    pipelineUtils.integrateJobs(['JobA','JobB','JobC'])
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    pipelineUtils.deploy()
                }
            }
        }
    }
}
