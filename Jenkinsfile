pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
//                 sh 'mvn clean install -DskipTests'
                bat 'mvn clean install -DskipTests'     // for executing on windows
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
}