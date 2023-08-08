node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/ZOSOpenTools/termenvport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/termenvport.git'), string(name: 'PORT_DESCRIPTION', value: 'termenv lets you safely use advanced styling options on the terminal. It gathers information about the terminal environment in terms of its ANSI & color support and offers you convenient methods to colorize and style your output, without you having to deal with all kinds of weird ANSI escape sequences and color conversions.' )]
  }
}
