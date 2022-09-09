pipelineJob("dsl-jobs/create-get-iplayer-docker-image") {
	description()
	keepDependencies(false)
	properties {
		nextBuildNumber(1)
	}

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
			scriptPath("jenkinsfile_lib/create_get_iplayer_docker_image")
		}
	}
	disabled(false)
}
}