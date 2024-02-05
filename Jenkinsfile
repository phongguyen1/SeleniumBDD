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
        stage('Export feature files') {
            steps{
                step([$class: 'XrayImportFeatureBuilder',
                        folderPath: 'src/test/resources/features',
                        projectKey: 'SCRUM',
                        serverInstance: '96c7bf87-ad73-4a77-9264-9a3b93a0903e'])
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
            
        }
        stage('Import results to Xray') {
            steps {
                step([
                    $class: 'XrayImportBuilder',
                    endpointName: '/cucumber',
                    projectKey: 'SCRUM',
                    importFilePath: 'target/cucumber/cucumber.html',
                    serverInstance: '96c7bf87-ad73-4a77-9264-9a3b93a0903e'
                ])
            }
        }

    }
    post {
                always {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
//                     sendSuccessNoti(teams_connectors_url)

                }
//                 failure {
//                     sendTeamsNoti(teams_connectors_url)
//                 }
            }
}