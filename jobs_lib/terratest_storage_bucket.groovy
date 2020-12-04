pipelineJob("terratest/terratest-storage-bucket") {
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
						credentials("github")
					}
					branch("*/main")
				}
			}
			scriptPath("jenkinsfile_lib/terratest_storage_bucket")
		}
	}
	disabled(false)
}