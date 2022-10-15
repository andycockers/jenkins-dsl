pipelineJob("dsl-jobs/create-jenkins-docker-image-plugins-jcasc") {
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
			scriptPath("jenkinsfile_lib/create_jenkins_docker_image_plugins_jcasc")
		}
	}
	disabled(false)
}
}