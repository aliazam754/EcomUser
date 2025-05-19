pipeline {
    agent any

    tools {
        maven 'maven-3.9.9'  // Make sure this matches exactly your Jenkins Maven tool name
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/aliazam754/EcomUser.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean test package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t aliaz333/ecomuser:latest .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d -p 8080:8080 --name ecomuser aliaz333/ecomuser:latest'
            }
        }
    }
}
