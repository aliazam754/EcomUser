pipeline {
    agent any

    tools {
        maven 'maven-3.9.9'  // Make sure this matches your Maven tool name in Jenkins
    }

    environment {
        IMAGE_NAME = 'aliaz333/ecom-user'
    }

    stages {
        stage('Clone GitHub Repo') {
            steps {
                git branch: 'main', url: 'https://github.com/aliazam754/EcomUser.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean test package '
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t aliaz333/test1 .'
            }
        }

        stage('Docker Run') {
            steps {
                sh 'docker rm -f ecom-user || true'
                sh 'docker run -d -p 9090:8080 --name aliaz333/test1'
            }
        }
    }
}
