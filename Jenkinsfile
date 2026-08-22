pipeline {

    agent any

    tools {
        jdk 'JDK21'
    }

    environment {
        APP_NAME = 'servicio-usuarios-jenkins'
        MAVEN_OPTS = '-Xmx1024m'
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Clonando repositorio: https://github.com/VainHyPerion7-cmd/${APP_NAME}"
                checkout scm
            }
        }

        stage('Validar Maven Wrapper') {
            steps {
                echo 'Validando Maven Wrapper...'
                sh 'chmod +x mvnw'
                sh './mvnw -version'
            }
        }

        stage('Limpiar y Compilar') {
            steps {
                echo 'Limpiando y compilando proyecto Spring Boot...'
                sh './mvnw clean compile'
            }
        }

        stage('Pruebas Unitarias') {
            steps {
                echo 'Ejecutando prueba unitaria específica: UsuariosControllerPruebaUnitariaJunitTest...'
                // Ejecuta únicamente tu clase de prueba JUnit
                sh './mvnw test -Dtest=UsuariosControllerPruebaUnitariaJunitTest'
            }
        }

        stage('Empaquetar JAR') {
            steps {
                echo 'Generando artefacto JAR (omitiendo tests para no repetirlos)...'
                sh './mvnw package -DskipTests'
            }
        }

        stage('Validar Artefacto') {
            steps {
                echo 'Mostrando archivos generados...'
                sh 'ls -lh target/'
            }
        }

    }

    post {
        success {
            echo "El pipeline para ${APP_NAME} finalizó con éxito."
        }
        failure {
            echo "Falló la construcción o las pruebas unitarias en ${APP_NAME}."
        }
        always {
            // Publica el reporte visual de JUnit en Jenkins si existen resultados
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
            echo 'Fin de ejecución en Jenkins.'
        }
    }
}