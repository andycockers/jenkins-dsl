def call () {
    script {
        checkout([$class: 'GitSCM', branches: [[name: "*/master"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github', url: "git@github.com:andycockers/gcp-automation.git"]]])
        sh "cd /usr/local/bin && wget https://releases.hashicorp.com/packer/1.6.5/packer_1.6.5_linux_amd64.zip && unzip packer_1.6.5_linux_amd64.zip"
        sh "cd packer/create-jenkins-gsutil-slave && packer build create-jenkins-gsutil-slave.json"

        
        
    }       
 }