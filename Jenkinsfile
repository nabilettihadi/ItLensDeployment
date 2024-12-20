pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script {
                    sh 'mvn sonar:sonar -Dsonar.host.url=http://<SONARQUBE_URL> -Dsonar.login=<SONARQUBE_TOKEN>'
                }
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    sh 'docker build -t nabilettihadi/it-lens-deployment:latest .'
                }
            }
        }
        stage('Docker Push') {
            steps {
                script {
                    sh 'docker push nabilettihadi/it-lens-deployment:latest'
                }
            }
        }
    }
    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}