def call () {
    script {
        checkout([$class: 'GitSCM', branches: [[name: "*/master"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github-3', url: "git@github.com:andycockers/gcp-automation.git"]]]) 
        withCredentials([string(credentialsId: 'ansible_vault', variable: 'VAULT')]) {
        sh "cd packer/install-jenkins-deps-hetzner && echo ${VAULT} | base64 -d > password && cat password && packer build install-jenkins-deps-hetzner.yml"
}
        
        
    }       
 }