pipeline {
  agent none
  stages {
    stage('Maven Install') {
      agent {
        docker {
          image 'maven:3.6.3'
        }
      }
      steps {
        sh 'sudo mvn clean install -DskipTests'
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