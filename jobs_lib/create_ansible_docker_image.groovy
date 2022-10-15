pipelineJob("dsl-jobs/create-ansible-docker-image") {
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
			scriptPath("jenkinsfile_lib/create_ansible_docker_image")
		}
	}
	disabled(false)
}
}