pipelineJob("ansible/ansible-decrypt-secret") {
	description()
	keepDependencies(false)
	options { buildDiscarder(logRotator(numToKeepStr: '5')) }


	//parameters {
	//	stringParam("CLUSTER_LOCATION", "amer", "gcp cluster locationd")
	//	stringParam("HOST_REGION", "us-west1", "gcp cluster region")
	//}

	definition {
		cpsScm {
			scm {
				git {
					remote {
						url("git@github.com:andycockers/jenkins-dsl.git")
						credentials("github")
					}
					branch("*/main")
				}
			}
			scriptPath("jenkinsfile_lib/ansible_decrypt_secret")
		}
	}
	disabled(false)
}