// def sendTeamsNoti(URL) {
//     def STATUS = currentBuild.resultIsBetterOrEqualTo('SUCCESS') ? 'SUCCESS' : 'FAILURE'
//     def COLOR = STATUS == 'SUCCESS' ? '00ff00' : 'ff4000'
//     def MESSAGE = STATUS == 'SUCCESS' ? 'Build successfully' : 'The build has failed, please check build logs'
//
//     office365ConnectorSend(
//                         status: "${env.STAGE_NAME} ${STATUS}",
//                         webhookUrl: "${URL}",
//                         color: "${COLOR}",
//                         message: "${MESSAGE}"
//                     )
// }
def teams_connectors_url = "https://everisgroup.webhook.office.com/webhookb2/032c533c-afa5-4a5a-9636-772cb4643fa5@3048dc87-43f0-4100-9acb-ae1971c79395/JenkinsCI/ebf089a22af74c6fa80823e277150508/5c631738-f567-4bf5-8574-ef82e04be7b4";

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
                    echo "Branch name: ${env.BRANCH_NAME}"
                    echo "Is Unix: ${isUnix()}"
                    if (isUnix()) {
                        if (env.BRANCH_NAME == 'dev') {
                            sh 'mvn test -Dcucumber.filter.tags=@dev -Dwebdriver.driver=chrome'
                        } else if (env.BRANCH_NAME == 'staging') {
                            sh 'mvn test -Dcucumber.filter.tags=@staging -Dwebdriver.driver=chrome'
                        } else {
                            sh 'mvn test -Dcucumber.filter.tags=@main -Dwebdriver.driver=chrome'
                        }
                    } else {
                        if (env.BRANCH_NAME == 'dev') {
                            bat 'mvn test -Dcucumber.filter.tags=@dev -Dwebdriver.driver=chrome'
                        } else if (env.BRANCH_NAME == 'staging') {
                            bat 'mvn test -Dcucumber.filter.tags=@staging -Dwebdriver.driver=chrome'
                        } else {
                            bat 'mvn test -Dcucumber.filter.tags=@main -Dwebdriver.driver=chrome'
                        }
                    }
                }
            }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
//                     sendSuccessNoti(teams_connectors_url)
                    // viết hàm connect với xray để đưa kết quả lên jira

                }
//                 failure {
//                     sendTeamsNoti(teams_connectors_url)
//                 }
            }
        }
//         stage('Publish to Xray') {
//             steps {
//                 withCredentials([usernamePassword(credentialsId: '994B835F0D85469495970CEFF61B9BE6', usernameVariable: 'XRAY_CLIENT_ID', passwordVariable: 'XRAY_CLIENT_SECRET')]) {
//
//                 }
//                 script {
//                     if (isUnix()) {
//                         sh 'curl -H "Content-Type: application/xml" -X POST -u $XRAY_CLIENT_ID:$XRAY_CLIENT_SECRET --data @target/surefire-reports/TEST-com.mycompany.myproject.MyTest.xml "https://xray.cloud.xpand-it.com/api/v1/import/execution/junit?projectKey=MYPROJECT"'
//                     } else {
//                         bat 'curl -H "Content-Type: application/xml" -X POST -u %XRAY_CLIENT_ID%:%XRAY_CLIENT_SECRET% --data @target\\surefire-reports\\TEST-com.mycompany.myproject.MyTest.xml "https://xray.cloud.xpand-it.com/api/v1/import/execution/junit?projectKey=MYPROJECT"'
//                     }
//                 }
//             }
//         }
    }
}