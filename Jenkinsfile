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
                bat 'mvn test -Dcucumber.filter.tags=@demo'
            }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success { allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                ])}
            }
        }
    }
}
