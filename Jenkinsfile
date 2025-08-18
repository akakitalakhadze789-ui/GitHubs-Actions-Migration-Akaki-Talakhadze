@Library('jenkins-shared-library@main') _
pipeline {
    agent { label 'aws-jenkins-worker' }

    stages {
        stage('Preparation') {
            steps {
                script {
                    runId = pipelineUtils.prepareRun()
                }
            }
        }

        stage('Run Jobs in Parallel') {
            steps {
                script {
                    parallel(
                        JobA: { pipelineUtils.runJob('JobA') },
                        JobB: { pipelineUtils.runJob('JobB') },
                        JobC: { pipelineUtils.runJob('JobC') }
                    )
                }
            }
        }

        stage('Integration') {
            steps {
                script {
                    pipelineUtils.integrateJobs(['JobA', 'JobB', 'JobC'])
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
