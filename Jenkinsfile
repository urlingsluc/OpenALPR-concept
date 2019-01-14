pipeline {
  agent any
  stages {
    stage('Verify Tools') {
      parallel {
        stage('java') {
          steps {
            sh 'java -version'
            sh 'which java'
          }
        }
        stage('maven') {
          steps {
            sh 'mvn -version'
            sh 'which mvn'
          }
        }
        stage('docker') {
          steps {
            sh 'docker --version'
            sh 'which docker'
          }
        }
      }
    }
    stage('Build') {
      steps {
        echo 'Building...'
        sh 'mvn clean install -B -DskipTests'
        sh 'docker build -t xti-parkingapp-alpr .'
      }
    }
    stage('Test') {
      steps {
        echo 'Testing...'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploying...'
        sh 'docker rm -f xti-parkingapp-alpr-con || true'
        sh 'docker run -d -p 9998:9998 --restart always --name xti-parkingapp-alpr-con xti-parkingapp-alpr'
        sh 'docker image prune -f'
      }
    }
  }
  post {
    always {
      cleanWs()

    }

  }
  options {
    disableConcurrentBuilds()
    timeout(time: 10, unit: 'MINUTES')
  }
}