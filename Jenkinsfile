pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Git clone') {
            steps {
                echo 'Cloning...'
                git branch: 'amin',
                url: 'https://github.com/ramihlioui/devops-jenkins.git',
                credentialsId: '4653dc97-7bb4-45ed-b139-1df8f9264054'
            }
        }
        stage('Test Maven') {
            steps {
                sh 'mvn -version'
            }
        }
    }
}
