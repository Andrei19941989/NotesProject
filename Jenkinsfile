pipeline {
    agent any

    environment {
        DB_URL = "jdbc:mysql://db:3306/notesdb?useSSL=false&allowPublicKeyRetrieval=true"
        DB_USER = "root"
        DB_PASSWORD = "Plm19941967"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Andrei19941989/NotesProject.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'docker build -t notes-app .'
                }
            }
        }

        stage('Run Containers') {
            steps {
                script {
                    sh 'docker-compose down' 
                    sh 'docker-compose up -d'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sleep 10 
                    sh 'docker ps' 
                }
            }
        }

        stage('Cleanup') {
            steps {
                script {
                    sh 'docker system prune -f' 
                }
            }
        }
    }
}
