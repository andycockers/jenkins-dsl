def call () {
    script {
        checkout([$class: 'GitSCM', branches: [[name: "*/master"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github-3', url: "git@github.com:andycockers/gcp-automation.git"]]]) 
        //sh "cat serviceaccount.json"
        sh "cd packer/install-install-jenkins-deps && packer build install-jenkins-deps.json"
        
    }       
 }