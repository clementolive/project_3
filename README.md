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
- You need to check this pull request, because default code redirects instantly when accessing rental creation form : 
https://github.com/OpenClassrooms-Student-Center/Developpez-le-back-end-en-utilisant-Java-et-Spring/pull/1/commits/f648ab800b1926bb491382ba062e3ff76ad84add
- open terminal in project folder
- install node modules with "npm install"
- run "ng serve"

4. Test the app 
- Run the associated Postman files in Postman from Openclassroom project page. You will need some changes in the JSON (or follow this link : https://api.postman.com/collections/26119928-5373f50a-bd58-470f-9474-f11f32a62863?access_key=PMAT-01GXS04JCZBWPQ0SPTY82H1ZNN)
- changed "email" instead of "login" in /login route. 
- removed Authorization Inherited from /register route. No JWT token should be sent when registering. 

- Or test manually on the adress http://localhost:4200/rentals
- You should get a JWT token on login or register. Use this token in headers to authenticate in any request. 

