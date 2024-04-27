pipeline {
  agent any

  tools {
    maven 'mvn-3.5.2'
  }

  stages {
    stage('Maven Build') {
      steps {
        sh 'mvn package'
      }
    }
	
    stage('Docker Build') {
      agent any
      steps {
		sh 'docker stop $(docker ps -a -q --filter ancestor=cloud-tech)'
        sh 'docker buildx build /var/lib/jenkins/workspace/cloud-tech -t cloud-tech:latest'
        sh 'docker run -d -p 8081:8081  -it cloud-tech'
      }
    }
  }
}