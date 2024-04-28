pipeline {
  agent any

  tools {
    maven 'Maven 3.6.3'
  }

  stages {
    stage('Clean up') {
	   steps {
	    sh 'cd /var/lib/jenkins/workspace/cloud-tech-ppl/'
		sh 'rm -rf ./target'
	   }
	}
	
    stage('Maven Build') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }
	
    stage('Docker Build') {
      agent any
      steps {
	    sh 'docker stop $(docker ps -a -q --filter ancestor=cloud-tech)'
	    sh 'docker rmi -f $(docker images -qa -f dangling=true)'
        sh 'docker buildx build /var/lib/jenkins/workspace/cloud-tech-ppl -t cloud-tech:latest'
        sh 'docker run -d -p 8081:8081  -it cloud-tech'
      }
    }
  }
}