pipelineJob("hpc/configure-qe") {
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
			scriptPath("jenkinsfile_lib/configure_qe")
		}
	}
	disabled(false)
}