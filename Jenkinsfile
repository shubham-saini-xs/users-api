@Library('jsl-helm-nginx') _ 

def deploymentConfig = [ 
    image: 'nginx:alpine' 
    // Add other custom values as needed 
] 
  
pipeline { 
    agent any
    environment {
        KUBECONFIG = '/home/xs309-shusai/.kube/config'
    }
    stages {
        stage('Connect to k8s cluster') {
            steps {
                script {
                    sh "export KUBECONFIG=$KUBECONFIG"
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
