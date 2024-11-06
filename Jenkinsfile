pipeline {
    agent any
    tools {
        maven 'maven_3_8_1'
        nodejs 'node'
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
                        sh 'docker build -t sebsatian/backend-prestabanco:latest PrestaBank-Backend'
                    } else {
                        bat 'docker build -t sebsatian/backend-prestabanco:latest PrestaBank-Backend'
                    }
                }
                withCredentials([string(credentialsId: 'docker-credentials', variable: 'dockerpw')]) {
                    script {
                        if (isUnix()) {
                            sh 'docker login -u sebsatian -p ${dockerpw}'
                        } else {
                            bat 'docker login -u sebsatian -p %dockerpw%'
                        }
                    }
                }
                script {
                    if (isUnix()) {
                        sh 'docker push sebsatian/backend-prestabanco:latest'
                    } else {
                        bat 'docker push sebsatian/backend-prestabancoo:latest'
                    }
                }
            }
        }
    }
}