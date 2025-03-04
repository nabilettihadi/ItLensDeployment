pipeline {
    agent any
    
    environment {
        DOCKER_CREDENTIALS = credentials('docker-hub-credentials')
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn sonar:sonar'
                }
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        
        stage('Docker Build') {
            steps {
                bat 'docker build -t nabilettihadi/it-lens-deployment:latest .'
            }
        }
        
        stage('Docker Login') {
            steps {
                bat 'echo %DOCKER_CREDENTIALS_PSW%| docker login -u %DOCKER_CREDENTIALS_USR% --password-stdin'
            }
        }
        
        stage('Docker Push') {
            steps {
                bat 'docker push nabilettihadi/it-lens-deployment:latest'
            }
        }
    }
    
    post {
        always {
            bat 'docker logout'
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}