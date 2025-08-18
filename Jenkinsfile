@Library('jenkins-shared-library@main') _

pipeline {
    agent any

    stages {
        stage('Preparation') {
            steps {
                script {
                    
                    env.varOcg = pipelineUtils.prepareRun()
                }
            }
        }

        stage('Parallel Jobs') {
            parallel {
                stage('Job1') {
                    steps {
                        script {
                            pipelineUtils.runJob("Job1")
                        }
                    }
                }
                stage('Job2') {
                    steps {
                        script {
                            pipelineUtils.runJob("Job2")
                        }
                    }
                }
                stage('Job3') {
                    steps {
                        script {
                            pipelineUtils.runJob("Job3")
                        }
                    }
                }
            }
        }

        stage('Integration') {
            steps {
                script {
                    pipelineUtils.integrateJobs(["Job1","Job2","Job3"])
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