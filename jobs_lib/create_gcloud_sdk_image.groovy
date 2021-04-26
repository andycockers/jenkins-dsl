pipelineJob("dsl-jobs/create-gcloud-sdk-image") {
	description()
	keepDependencies(false)

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
			scriptPath("jenkinsfile_lib/create_gcloud_sdk_image")
		}
	}
	disabled(false)
}