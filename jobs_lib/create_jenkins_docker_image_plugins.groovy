pipelineJob("dsl-jobs/create-jenkins-docker-image-plugins") {
	description()
	keepDependencies(false)
	properties {
		nextBuildNumber(1)
	}
	triggers {
        scm("H/5 * * * *")
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
					configure {
                        it / extensions / "hudson.plugins.git.extensions.impl.PathRestriction" {
                            includedRegions("dockerfiles/jenkins-plugins/*.*")
                            excludedRegions('')
                        }
				}
			}
			scriptPath("jenkinsfile_lib/create_jenkins_docker_image_plugins")
		}
	}
	disabled(false)
}
}