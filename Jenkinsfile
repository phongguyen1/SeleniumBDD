pipeline {
    agent any
    parameters {
        choice(name: 'BUILD_ENV', choices: ['dev', 'staging', 'main'], description: 'Which environment to build')
    }
    stages {
        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn clean install -DskipTests'
                    } else {
                        bat 'mvn clean install -DskipTests'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        if (params.BUILD_ENV == 'dev') {
                            sh 'mvn test -Dcucumber.filter.tags=@dev'
                        } else if (params.BUILD_ENV == 'staging') {
                            sh 'mvn test -Dcucumber.filter.tags=@staging'
                        } else if (params.BUILD_ENV == 'main') {
                            sh 'mvn test -Dcucumber.filter.tags=@main'
                        }
                    } else {
                        if (params.BUILD_ENV == 'dev') {
                            bat 'mvn test -Dcucumber.filter.tags=@dev'
                        } else if (params.BUILD_ENV == 'staging') {
                            bat 'mvn test -Dcucumber.filter.tags=@staging'
                        } else if (params.BUILD_ENV == 'main') {
                            bat 'mvn test -Dcucumber.filter.tags=@main'
                        }
                    }
                }
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