# Jersan - Gestor de Reservaciones de Vehículos

Jersan es una aplicación móvil de gestión de reservaciones para vehículos, desarrollada en Android Studio con Kotlin. El proyecto fue realizado con fines académicos y no ha sido desplegado. Su funcionalidad principal es permitir a los usuarios realizar reservaciones de vehículos, gestionando los vehículos disponibles mediante operaciones CRUD (crear, leer, actualizar y eliminar).

## Características principales

- **Reservas de vehículos**: Permite a los usuarios hacer reservaciones solo cuando el vehículo esté disponible.
- **CRUD de reservaciones**: El sistema permite crear, leer, actualizar y eliminar las reservaciones de vehículos.
- **Base de datos local**: Se utiliza Room para manejar la base de datos local de las reservaciones.

## Requisitos previos

- **Android Studio**: Necesario para compilar y ejecutar el proyecto.
- **Kotlin**: El proyecto está desarrollado en Kotlin.
- **Dispositivo Android**: O emulador para ejecutar la aplicación.

## Instalación

1. **Clonar el repositorio en tu máquina local**:

    ```sh
    git clone https://github.com/tu-usuario/jersan.git
    cd jersan
    ```

2. **Abrir el proyecto en Android Studio**: Importa el proyecto desde el IDE de Android Studio.

3. **Compilar y ejecutar**: Compila el proyecto en tu dispositivo o emulador.

## Características Técnicas

- **Plugins**: El proyecto utiliza los siguientes plugins de Gradle:
  
    ```gradle
    plugins {
        id 'com.android.application'
        id 'org.jetbrains.kotlin.android'
        id 'kotlin-kapt'
    }
    ```

- **Dependencias clave**:
    - **Room**: Para la gestión de la base de datos local.
    - **Navigation**: Para la navegación entre pantallas.
    - **Lifecycle**: Para la integración de LiveData y ViewModel en la arquitectura de la app.
    - **Material**: Para los componentes visuales Material Design.


    ```gradle
    dependencies {
        implementation 'androidx.room:room-ktx:2.2.5'
        implementation 'androidx.room:room-runtime:2.2.5'
        kapt 'androidx.room:room-compiler:2.2.5'
        // Otras dependencias...
    }
    ```

## Notas

Este proyecto no fue desplegado en producción ya que es una solución académica. Sin embargo, es completamente funcional para realizar reservaciones dentro de un sistema de gestión de vehículos auque requiere mejoras a nivel de realizar una reservación en selección de las fechas necesarias. 

## Tecnologías utilizadas

- **Kotlin**: Lenguaje de programación utilizado para el desarrollo de la aplicación.
- **Android Studio**: IDE utilizado para la creación del proyecto.
- **Room**: Biblioteca de base de datos local utilizada para almacenar la información de las reservaciones.

