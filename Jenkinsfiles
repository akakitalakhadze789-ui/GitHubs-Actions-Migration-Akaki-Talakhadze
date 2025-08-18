@Library('jenkins-shared-library@main') _
pipeline {
    agent {
        label 'aws-jenkins-worker'
    }
    
    stages {
        stage('Hello World Demo') {
            steps {
                script {
                    helloworld()
                }
            }
        }
        
        stage('Hello with Name') {
            steps {
                script {
                    helloworld('Jenkins Team')
                }
            }
        }
    }
}