pipelineJob("dsl-jobs/helm-repo-shizzle") {
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
			scriptPath("jenkinsfile_lib/helm_repo_shizzle")
		}
	}
	disabled(false)
}
}