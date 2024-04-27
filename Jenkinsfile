pipeline {
  agent none
  stages {
    stage('Maven') {
      steps {
        sh 'cd /var/lib/jenkins/workspace/cloud-tech/ && mvn clean package -DskipTests'
      }
    }
    stage('Docker') {
      agent any
      steps {
		sh 'docker stop $(docker ps -a -q --filter ancestor=cloud-tech)'
        sh 'docker buildx build /var/lib/jenkins/workspace/cloud-tech -t cloud-tech:latest'
        sh 'docker run -d -p 8081:8081  -it cloud-tech'
      }
    }
  }
}