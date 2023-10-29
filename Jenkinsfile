pipeline {
    agent any
    tools {
        maven 'Maven 3.9.5'
        jdk 'jdk11'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

    	stage ('checkout code') {
    		steps {
    	        checkout scm
    		}
    	}
    	
    	stage ('Build'){
    		steps {
    		    sh "mvn clean install -Dmaven.test.skip=true"
    		}
    	}
    	
    	stage ('Test Case Execution'){
    		steps {
    		    sh "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Pcoverage-per-test"
    		}	                
    	}
    	
    	stage ('Archive Artifacts'){
    		steps {
    	 		archiveArtifacts artifacts: 'target/*.war'         
    		}
    	}
    	
    	stage ('Deployment'){
    		steps {
    		    deploy adapters: [tomcat9(credentialsId: 'TomcatCreds', path: '', url: 'http://192.168.1.230:8080/')], contextPath: 'JsoupWebScrapper',
    	    	war: 'target/*.war'
    		}
    	}
    	
    	stage ('Notification'){
    		steps {
    		    emailtext(
    	    			subject: "Job Completed",
    	    			body: "Jenkins Pipeline Job for Maven Build got Cpmpleted !!!",
    	    			to: "build-alerts@example.com")
    		}   	
    	}

	}
}
