@Library('nginx-deployment-lib') _ 

def deploymentConfig = [ 
    image: 'nginx:alpine' 
    // Add other custom values as needed 
] 
  
pipeline { 
    agent any
    environment {
        KUBECONFIG = '/home/xs309-shusai/Downloads/dataops-cluster-k8s'
    }
    stages {
        stage('Connect to k8s cluster') {
            steps {
                script {
                    sh "export KUBECONFIG=\$KUBECONFIG"
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
