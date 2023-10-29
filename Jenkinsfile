pipeline{
    agent any
    tools{
        maven 'Maven 3.9.5'
        jdk 'jdk11'
    }

	node('built-in') {
	
		stage ('Initialize'){
		    	sh '''
		    		echo "PATH = ${PATH}"
		    		echo "M2_HOME = ${M2_HOME}"
		    	''' 		
		}

    	stage ('checkout code'){
    	        checkout scm
    	}
    	
    	stage ('Build'){
    	    	sh "mvn clean install -Dmaven.test.skip=true"
    	}
    	
    	stage ('Test Case Execution'){
    	 		sh "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Pcoverage-per-test"                
    	}
    	
    	stage ('Archive Artifacts'){
    	 		archiveArtifacts artifacts: 'target/*.war'         
    	}
    	
    	stage ('Deployment'){
    	    	deploy adapters: [tomcat9(credentialsId: 'TomcatCreds', path: '', url: 'http://192.168.1.230:8080/')], contextPath: 'JsoupWebScrapper',
    	    	war: 'target/*.war'
    	    
    	}
    	
    	stage ('Notification'){
    	    	emailtext(
    	    			subject: "Job Completed",
    	    			body: "Jenkins Pipeline Job for Maven Build got Cpmpleted !!!",
    	    			to: "build-alerts@example.com")
    	}

	}
}
