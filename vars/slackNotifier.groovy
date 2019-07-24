// vars/slackNotifier.groovy

def call(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", message: "${env.JOB_NAME} - #${env.BUILD_NUMBER} was successful\nLink : ${env.BUILD_URL}"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "${env.JOB_NAME} - #${env.BUILD_NUMBER} was failed\nLink : ${env.BUILD_URL}"
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "${env.JOB_NAME} - #${env.BUILD_NUMBER} was unstable\nLink : ${env.BUILD_URL}"
  }
  else {
    slackSend color: "danger", message: "${env.JOB_NAME} - #${env.BUILD_NUMBER} its result was unclear\nLink : ${env.BUILD_URL}"	
  }
}
