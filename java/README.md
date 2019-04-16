# Ejemplo Aplicación Web (Rest Api) con Maven y Docker

## Pre-requisitos

- Configurar [Maven](https://maven.apache.org/install.html)
- Instalar y configurar Docker
    - [Docker para windows](https://docs.docker.com/docker-for-windows/install)
    - [Docker for Mac](https://docs.docker.com/docker-for-mac/install/)
 
 ## Compilar la aplicación
 
 
 ´´´
 
    mvn clean install
 
 ´´´
 
 
 ## Construir la Imagen Docker
 
 
  
 ´´´
 
    mvn install dockerfile:build
 
 ´´´
 