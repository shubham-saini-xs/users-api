def call(Map config) {  // function call- take argument config which is Map
    // Define all default values for Helm chart values - these will be replaced according to values defined in jenkinsfile.
    def defaults = [ 
        image: 'nginx:latest', 
        portType: 'NodePort' 
    ] 
  
    // Merge provided configuration with defaults - Basically config Map overlaps the defaults Map
    def helmValues = defaults + config 
  
    stage("Deploy Nginx Application") { //stage defined jenkins Pipeline stage
        // Generating Helm Set Arguments -  iterates through key-value pairs in helmValues and and constructs string in format "--set key=value"
        // Then these values are joined together with space.
        def helmSetArgs = helmValues.collect { key, value -> "--set ${key}=${value}" }.join(' ') 
        // Helm Deployment - executes a shell command in jenkins - deploy using helm chart
        sh "helm upgrade --install my-nginx-chart ./resources/ -f ./resources/values.yaml ${helmSetArgs}" 
            // Helm to upgrade an existing release or install a new one if it doesn't exist
            // Name -  Helm release
            // path,  file
            // Helm set arguments generated earlier, which pass custom configuration values to the Helm chart.
    } 
} 
