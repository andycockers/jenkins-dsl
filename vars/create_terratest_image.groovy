def call () {
    script {
        checkout([$class: 'GitSCM', branches: [[name: "*/master"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github', url: "git@github.com:andycockers/gcp-automation.git"]]])
        sh "cd packer/create-terratest-image && packer build create-terratest-image.json"

        
        
    }       
 }