pipeline {
    agent any
    tools {
        maven "maven"  
    }
    stages {
        stage('Checkout Code') {
            steps {
                checkout scmGit(
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[url: 'https://github.com/Rbd-Antoine/PrestaBanco']]
                )
            }
        }

        stage('Build Maven') {
            steps {
                dir('PrestaBank-Frontend') { 
                    bat 'npm install'
                    bat 'npm run build'
                }
            }
        }

        stage('Build and Push Image to Docker Hub') {
            steps {
                dir('PrestaBank-Frontend'){
                    script {
                        withDockerRegistry(credentialsId: 'docker-credentials') {
                            bat 'docker build -t rbdantoine/frontend-image .'
                            bat 'docker push rbdantoine/frontend-image'
                        }
                    }
                }
            }
        }
    }
}