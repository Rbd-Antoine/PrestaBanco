pipeline{
    agent any
    tools{
        maven "maven"

    }
    stages{
        stage("Build JAR File"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Rbd-Antoine/PrestaBanco']])
            }
        }
        stage('Build backend') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'cd PrestaBank-Backend && mvn clean package'
                    } else {
                        bat 'cd PrestaBank-Backend && mvn clean package'
                    }
                    
                }
            }
        }
        stage("Test"){
            steps{
                dir("PrestaBank-Backend"){
                    bat "mvn test"
                }
            }
        }        
        stage("Build and Push Docker Image"){
            steps{
                dir("PrestaBank-Backend"){
                    script{
                         withDockerRegistry(credentialsId: 'docker-credentials'){
                            bat "docker build --no-cache -t rbdantoine/frontend-image:latest ."
                            bat "docker push rbdantoine/frontend-image:latest"
                        }
                    }                    
                }
            }
        }
    }
}