pipeline {
    agent any

    environment {
        PATH = "${env.PATH}:/usr/local/bin" // Update the PATH to include the directory of cmd.exe
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/eliaspehkonen/Lecture_Assignment_15.2.git'
            }
        }

        stage('Build') {
            steps {
                withMaven(maven: 'MAVEN_HOME') {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                withMaven(maven: 'MAVEN_HOME') {
                    sh 'mvn test'
                }
            }

            post {
                success {
                    // Publish JUnit test results
                    junit '**/target/surefire-reports/TEST-*.xml'

                    // Generate JaCoCo code coverage report
                    jacoco(execPattern: '**/target/jacoco.exec')
                }
            }
        }
    }
}
