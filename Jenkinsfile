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
    }
}
