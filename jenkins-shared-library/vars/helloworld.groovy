def call(String name = 'World') {
    echo "Hello, ${name}!"
    echo "This message is from Jenkins Shared Library"
    echo "Build Number: ${env.BUILD_NUMBER}"
    echo "Job Name: ${env.JOB_NAME}"
    echo "Current Time: ${new Date()}"
}