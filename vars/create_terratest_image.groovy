def call () {
    script {
        checkout([$class: 'GitSCM', branches: [[name: "*/master"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github', url: "git@github.com:andycockers/gcp-automation.git"]]]) 
        sh "cd packer/create-jenkins-gsutil-slave && packer build create-jenkins-gsutil-slave.json"

        
        
    }       
 }