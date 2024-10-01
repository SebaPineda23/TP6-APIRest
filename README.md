# TPNº6-Proyecto Spring Boot con Auditoría, MVC y API Genérica

Este proyecto es una aplicación web construida con **Spring Boot**. Implementa auditoría mediante **Hibernate Envers**, utiliza el patrón de diseño **Modelo-Vista-Controlador (MVC)** y define una **API genérica** para el manejo de entidades. El proyecto emplea **MySQL** y **H2** para la persistencia de datos.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.3.4**
- **Spring Data JPA**
- **Spring Data REST**
- **Hibernate Envers** (para auditoría de entidades)
- **H2** (base de datos en memoria para pruebas)
- **MySQL** (base de datos principal)
- **Lombok** (para eliminar código boilerplate)
- **JUnit** (para pruebas unitarias)
- **Spring REST Docs** (para documentar la API)

## Instalación y Configuración

### Requisitos Previos

- **JDK 17** o superior
- **Maven** o **Gradle** (ya configurado en este proyecto con **Gradle**)
- **MySQL** (asegúrate de tener una base de datos configurada en `application.properties`(En el proyecto esta comentada su configuración para posibles pruebas si no se quiere implementar H2))
- **H2 DataBase** (asegúrate de tener una base de datos configurada en `application.properties`(En el proyecto esta sin comentar, listo para probarlo en H2))
### Configuración de la Base de Datos

Asegúrate de tener una base de datos MySQL activa o H2 y configura los siguientes detalles en tu archivo `src/main/resources/application.properties`:

