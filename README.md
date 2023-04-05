# ChâTop - Backend 
This is an API for a rental website, as an Openclassroom project. 

## Documentation 
For using Springdoc documentation :
https://springdoc.org/v2/

The OpenAPI description will be available at the following url for json format:
http://localhost:8080/v3/api-docs

API Documentation :
http://localhost:8080/swagger-ui/index.html#/

## Tools
This project uses: 
- **Spring Boot**
- **Spring Security**  
- **Mapstruct** for repository Mapper 
Find more info on pom.xml for dependencies. 

It is used in combination with a MySQL database hosted by Wamp for development purposes. 
The development involved Postman to test the API. 

## File structure 
This is a layer-based architecture, Controller-Service-Repository-Database.

## How to use 
git clone, and run. 
You will need a local database called rentals on port 3306
Change database credentials as needed, in application.properties
This is backend is intended to be used with this Angular frontend https://github.com/OpenClassrooms-Student-Center/Developpez-le-back-end-en-utilisant-Java-et-Spring
