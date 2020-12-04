def call () {
    script {
        checkout([$class: 'GitSCM', branches: [[name: "*/master"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github', url: "git@github.com:andycockers/kubernetes.git"]]]) 
        withCredentials([file(credentialsId: 'jenkins-test-project', variable: 'GOOGLE_APPLICATION_CREDENTIALS')]) {
        sh "cd terratest/gcp/compute-engine && go mod init github.com/gruntwork-io/terratest/tree/master/modules/terraform"
        sh "cd terratest/gcp/compute-engine && go test"
}
        
        
    }       
 }