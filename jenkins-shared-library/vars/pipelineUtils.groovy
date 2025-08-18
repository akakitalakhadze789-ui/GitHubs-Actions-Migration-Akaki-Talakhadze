// __define-ocg__ Jenkins Shared Library Utility
def call() {
    echo "pipelineUtils library loaded ✅"
}

// Prepare run
def prepareRun() {
    def varOcg = UUID.randomUUID().toString()   // required variable
    echo "Preparation stage: RunID=${varOcg}"
    writeFile file: "prep.txt", text: "RunID=${varOcg}\n"
    stash includes: "prep.txt", name: "prepData"
    return varOcg
}

// Run a single job
def runJob(String jobName) {
    unstash "prepData"
    sh """
      echo '${jobName} running with $(cat prep.txt)' > ${jobName}.log
    """
    stash includes: "${jobName}.log", name: "${jobName}Data"
    echo "${jobName} complete"
}

// Integrate multiple jobs
def integrateJobs(List jobNames) {
    jobNames.each { unstash "${it}Data" }
    sh "cat ${jobNames.collect { it + '.log' }.join(' ')} > combined.txt"
    stash includes: "combined.txt", name: "integrationData"
    echo "Integration complete"
}

// Deploy
def deploy() {
    unstash "integrationData"
    echo "Deploy step using combined results:"
    sh "cat combined.txt"
}
