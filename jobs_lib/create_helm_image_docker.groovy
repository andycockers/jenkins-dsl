pipelineJob("dsl-jobs/create-helm-image-docker") {
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
			scriptPath("jenkinsfile_lib/create_helm_image_docker")
		}
	}
	disabled(false)
}