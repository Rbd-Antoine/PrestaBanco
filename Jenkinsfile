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
                stage('Test backend') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'cd PrestaBank-Backend && mvn test'
                    } else {
                        bat 'cd PrestaBank-Backend && mvn test'
                    }
                }
            }
        }
        stage('Push backend') {
            steps {

                script {
                    if (isUnix()) {
                        sh 'docker build -t rbdantoine/backend-image:latest .'
                    } else {
                        bat 'docker build -t rbdantoine/backend-image:latest .'
                    }
                }
                script {
                    if (isUnix()) {
                        sh 'docker push rbdantoine/backend-image:latest'
                    } else {
                        bat 'docker push rbdantoine/backend-image:latest'
                    }
                }
            }
        }
    }
}