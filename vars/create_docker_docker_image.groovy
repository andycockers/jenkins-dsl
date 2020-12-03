def call () {
    script {
        checkout([$class: 'GitSCM', branches: [[name: "*/master"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github', url: "git@github.com:andycockers/gcp-automation.git"]]])
        sh "cd packer/create-docker-docker-image && packer build create-docker-docker-image.json"

        
        
    }       
 }