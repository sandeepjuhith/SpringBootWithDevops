pipeline {
    agent any
    tools {
        maven 'maven_home'
     }

    stages {
        stage('Build') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [],
                userRemoteConfigs: [[url: 'https://github.com/sandeepjuhith/SpringBootWithDevops']]])
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    bat 'docker build -t 300114/springbootwithdevops .'
                }
            }
        }
        stage('Push Docker Image to docker hub') {
            steps {
                script {
                    //withCredentials([string(credentialsId: 'dockerhub-password', variable: 'dockerpassword')]) {
                       // bat 'docker login -u 300114 -p testpwd'
                    //}
                    //bat 'docker push 300114/springbootwithdevops'
                }
            }
        }

        stage("build & SonarQube analysis") {
            steps {
                withSonarQubeEnv('My SonarQube Server') {
                    bat 'mvn clean package sonar:sonar'
                }
            }
        }
        stage("Quality Gate") {
            steps {
                 timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                 }
            }
        }

    }
}
