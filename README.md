## Doora course navigation App with spring boot & Angular 4

### Introduction
A course navigation for UNSW to learn about restful and angular 4 concepts using
 Spring boot, Spring Security integrate with jwt token and angular.

### Run
* To run the project, clone it, and import it into your favorite IDE.
* The main entry point is MainApplication.java.
* Open browser and navigate to http://localhost:8080
* To log into the application, use the the ADMIN account (295046974@qq.com / 123).
* Go to http://localhost:8080/swagger-ui.html for Swagger (API Ref).

### Database
Navigate to http://localhost:8080/h2-console to look at the database content.
```
   *Driver Class: org.h2.Driver 
   *JDBC URL: jdbc:h2:file:./demo 
   *User Name: sa 
   *Password: 
```

### Unit Test
Unit Test module includes register, post & apply in ./test/e2e-test/