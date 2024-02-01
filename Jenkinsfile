pipeline {
    agent any
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
                        if (env.BRANCH_NAME == 'dev') {
                            sh 'mvn test -Dcucumber.filter.tags=@dev -Dwebdriver.driver=chrome'
                        } else if (env.BRANCH_NAME == 'staging') {
                            sh 'mvn test -Dcucumber.filter.tags=@staging -Dwebdriver.driver=chrome'
                        } else if (env.BRANCH_NAME == 'main') {
                            sh 'mvn test -Dcucumber.filter.tags=@main -Dwebdriver.driver=chrome'
                        }
                    } else {
                        if (env.BRANCH_NAME == 'dev') {
                            bat 'mvn test -Dcucumber.filter.tags=@dev -Dwebdriver.driver=chrome'
                        } else if (env.BRANCH_NAME == 'staging') {
                            bat 'mvn test -Dcucumber.filter.tags=@staging -Dwebdriver.driver=chrome'
                        } else if (env.BRANCH_NAME == 'main') {
                            bat 'mvn test -Dcucumber.filter.tags=@main -Dwebdriver.driver=chrome'
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