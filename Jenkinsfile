pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {

        stage('Checkout repository') {
            steps {
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
                        sh 'docker build -t rbdantoine/backend-prestabanco:latest PrestaBank-Backend'
                    } else {
                        bat 'docker build -t rbdantoine/backend-prestabanco:latest PrestaBank-Backend'
                    }
                }
                withCredentials([string(credentialsId: 'docker-credentials', variable: 'dockerpw')]) {
                    script {
                        if (isUnix()) {
                            sh 'docker login -u rbdantoine -p ${dockerpw}'
                        } else {
                            bat 'docker login -u rbdantoine -p %dockerpw%'
                        }
                    }
                }
                script {
                    if (isUnix()) {
                        sh 'docker push rbdantoine/backend-prestabanco:latest'
                    } else {
                        bat 'docker push rbdantoine/backend-prestabancoo:latest'
                    }
                }
            }
        }
        stage('Build frontend') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'cd PrestaBank-Frontend && npm install'
                        sh 'cd PrestaBank-Frontend && npm run build'
                    } else {
                        sh 'cd PrestaBank-Frontend && npm install'
                        bat 'cd PrestaBank-Frontend && npm run build'
                    }
                }
            }
        }
        stage('Push frontend') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'docker build -t rbdantoine/frontend-prestabanco:latest PrestaBank-Frontend'
                    } else {
                        bat 'docker build -t rbdantoine/frontend-prestabanco:latest PrestaBank-Frontend'
                    }
                }

                withCredentials([string(credentialsId: 'docker-credentials', variable: 'dockerpw')]) {
                    script {
                        if (isUnix()) {
                            sh 'docker login -u rbdantoine -p ${dockerpw}'
                        } else {
                            bat 'docker login -u rbdantoine -p %dockerpw%'
                        }
                    }
                }
                script {
                    if (isUnix()) {
                        sh 'docker push rbdantoine/frontend-prestabanco:latest'
                    } else {
                        bat 'docker push rbdantoine/frontend-prestabanco:latest'
                    }
                }
            }
        }
    }
}