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
1. Setup your database :
- Setup an empty database called "rentals" on port 3306 with any software (Wamp, command line...) 

2. Setup the backend : clone this repository 
- git clone https://github.com/achmoye/project_3_spring
- Open in your IDE, open Application.java in a tab and right click -> run 
- Change database credentials as needed, in application.properties

3. Setup the frontend : 
- git clone https://github.com/OpenClassrooms-Student-Center/Developpez-le-back-end-en-utilisant-Java-et-Spring
- open terminal in project folder
- install node modules with "npm install"
- run "ng serve"

