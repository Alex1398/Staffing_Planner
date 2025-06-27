# Staffing_Planner
﻿# Getting Started

### Requirements
For building and running the application you need:

- [JDK 17] https://www.oracle.com/java/technologies/downloads/#java17
- [Maven 3] https://maven.apache.org

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.Staffing_Planner.Staffing_Planner.StaffingPlannerApplication` class from your IDE.

Alternatively you can build the project by running ```mvn clean package```

Once successfully built, you can run the service by one of these two methods:
```
        java -jar target/Staffing_Planner-0.0.1-SNAPSHOT.jar
or
        mvn spring-boot:run"
```

## Database
Database is already set up in `application.properties` with test seeds.
If you want another seeds can uncomment `loadData` function from  `com.Staffing_Planner.Staffing_Planner.StaffingPlannerApplication`.

If you want to connect your own mongodb database create a new mongodb database:
[MongoDB] https://www.mongodb.com/resources/products/fundamentals/create-database
After that get connection string: 
[Connection String] https://www.mongodb.com/basics/mongodb-connection-string

Connection string must be placed in `application.properties` `spring.data.mongodb.uri` then in `spring.data.mongodb.uri` specify desired database and into `server.port` locally running port.

### Get information about movies and users.

```
GET/POST http://localhost:8080/api/employees 
GET/POST http://localhost:8080/api/wishes
POST     http://localhost:8080/api/assign
GET      http://localhost:8080/api/schedule?date={date}
```


