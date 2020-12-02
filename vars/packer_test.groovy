def call () {
    script {
        checkout([$class: 'GitSCM', branches: [[name: "*/master"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github-3', url: "git@github.com:andycockers/gcp-automation.git"]]]) 
        //sh "cat serviceaccount.json"
        sh "echo $VAULT > password"
        sh "cd packer/install-jenkins-deps-hetzner && packer build install-jenkins-deps-hetzner.yml"
        
    }       
 }