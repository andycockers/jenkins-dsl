def call () {
    script {
        checkout([$class: 'GitSCM', branches: [[name: "*/master"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github', url: "git@github.com:andycockers/gcp-automation.git"]]]) 
        withCredentials([string(credentialsId: 'hetzner', variable: 'TOKEN'), string(credentialsId: 'ansible-vault', variable: 'VAULT')]) {
        sh "cd packer/install-jenkins-deps-hetzner && echo $VAULT > password && packer build install-jenkins-deps-hetzner.yml"
}
        
        
    }       
 }