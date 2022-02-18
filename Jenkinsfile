pipeline {
    agent any
	
	environment {
        EMAIL_TO = 'souhaib.aljaziri@gmail.com'
    }
	
    stages {
	
		/*stage('PreBuild-Email') {
           steps {
               script {
                   def mailRecipients = 'souhaib.aljaziri@gmail.com'
                   def jobName = currentBuild.fullDisplayName
                   //emailext body: '''${SCRIPT, template="groovy-html.template"}''',
                   emailext body: '''Hello''',
                       mimeTye: 'text/html',
                       subject: "[Jenkins] Started ${jobName}",
                       to: "${mailRecipients}",
                       replyTo: "${mailRecipients}",
                       recipientProviders: [[$class: 'CulpritsRecipientProvider']]
						}
					}
		}	*/
	
		/*stage('PREPARE ENVIRONMENT') {
            steps {
                echo 'Getting Project';
                sh 'sudo docker stop timerContaine$(($BUILD_ID - 1))';
            }
        }*/
	
        stage('GIT') {
            steps {
                echo 'Getting Project';
                git 'https://github.com/ahmedTouati/prjDevops.git';
            }
        }
        
        stage('MVN CLEAN') {
            steps {
                echo 'Cleaning Project';
                sh 'sudo mvn clean'
            }
        }
        
		stage('MVN COMPILE') {
            steps {
                echo 'Compile Project';
                sh 'sudo mvn clean install';
                
            }
        }	
		
        stage('MVN TEST SONAR') {
            steps {
                echo 'Qualite Project';
                sh 'sudo mvn sonar:sonar';
            }
        }
		
    }
	post {
         success {  
             mail bcc: '', body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}", cc: '', from: '', replyTo: '', subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}", to: 'souhaib.aljaziri@gmail.com'
         }  
         failure {  
		     mail bcc: '', body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}", cc: '', from: '', replyTo: '', subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}", to: 'souhaib.aljaziri@gmail.com'
         }
     }

}
