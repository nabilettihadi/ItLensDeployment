pipeline {
    agent any
    
    environment {
        MAVEN_HOME = 'C:\\apache-maven-3.8.8'
        PATH = "${MAVEN_HOME}\\bin;${env.PATH}"
        DOCKER_CREDENTIALS = credentials('docker-hub-credentials')
    }

    stages {
        stage('Build') {
            steps {
                bat "${MAVEN_HOME}\\bin\\mvn clean package -DskipTests"
            }
        }
        
        stage('Test') {
            steps {
                bat "${MAVEN_HOME}\\bin\\mvn test"
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
                    bat "${MAVEN_HOME}\\bin\\mvn sonar:sonar"
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
                withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    bat 'echo %DOCKER_PASS%| docker login -u %DOCKER_USER% --password-stdin'
                }
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
            node('any') {
                bat 'docker logout'
            }
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}