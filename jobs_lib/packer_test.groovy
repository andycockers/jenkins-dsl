pipelineJob("dsl-jobs/packer-test") {
	description()
	keepDependencies(false)

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
						credentials("andycockers")
					}
					branch("*/master")
				}
			}
			scriptPath("jenkinsfile_lib/packer_test")
		}
	}
	disabled(false)
}