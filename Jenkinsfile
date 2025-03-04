pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Andrei19941989/NotesProject.git'
            }
        }

        stage('Build and Run') {
            steps {
                script {
                    sh 'docker-compose down' // Остановка старого контейнера, если он есть
                    sh 'docker-compose up --build -d' // Сборка и запуск нового
                }
            }
        }
    }
}
