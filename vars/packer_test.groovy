def call () {
    script {
        checkout([$class: 'GitSCM', branches: [[name: "*/master"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'appno_bitbucket', url: "git@bitbucket.org:appno/paas-multi-terraform-library.git"]]]) 
        //sh "cat serviceaccount.json"
        sh "cd packer/create-jenkins-gsutil-slave && packer build create-jenkins-gsutil-slave.json"
        
    }       
 }