@Library('jsl-helm-nginx') _ 

def deploymentConfig = [ 
    image: 'nginx:alpine' 
    // Add other custom values as needed 
] 
  
pipeline { 
    agent any
    environment {
        KUBECONFIG = credentials('1')
    }
    stages {
        stage('Connect to k8s cluster') {
            steps {
                script {
                    withCredentials([file(credentialsId: '1', variable: 'KUBECONFIG')]) {
                    sh "export KUBECONFIG=$KUBECONFIG"
                    }
                }
            }
        }  
        stage('Deploy Nginx') { 
            steps { 
                script { 
                    deployNginx(deploymentConfig) 
                } 
            } 
        } 
    } 
} 
