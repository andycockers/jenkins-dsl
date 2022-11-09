pipelineJob("dsl-jobs/create-genrss-arm64-image") {
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
			scriptPath("jenkinsfile_lib/create_genrss_arm64_docker_image")
		}
	}
	disabled(false)
}