pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9'  // Make sure this matches your Jenkins Maven version
    }

    stages {
        stage('Clone Code') {
            steps {
                git 'https://github.com/aliazam754/EcomUser.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean install'
            }
        }
    }

    post {
        success {
            echo 'Build Success!'
        }
        failure {
            echo 'Build Failed!'
        }
    }
}
