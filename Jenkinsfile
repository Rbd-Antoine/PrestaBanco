pipeline{
    agent any
    tools{
        maven "maven"

    }
    stages{
        stage("Build JAR File"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Rbd-Antoine/PrestaBanco']])
                dir("gestion-estudiantes-backend"){
                    bat "mvn clean install"
                }
            }
        }
        stage("Test"){
            steps{
                dir("gestion-estudiantes-backend"){
                    bat "mvn test"
                }
            }
        }        
        stage("Build and Push Docker Image"){
            steps{
                dir("gestion-estudiantes-backend"){
                    script{
                         withDockerRegistry(credentialsId: 'docker-credentials'){
                            bat "docker build -t rbdantoine/gestion-estudiantes-backend ."
                            bat "docker push rbdantoine/gestion-estudiantes-backend"
                        }
                    }                    
                }
            }
        }
    }
}