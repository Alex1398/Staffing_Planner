# Staffing_Planner
﻿# Getting Started

### Requirements
For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org)

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
[MongoDB](https://www.mongodb.com/resources/products/fundamentals/create-database).
After that get connection string: 
[Connection String](https://www.mongodb.com/basics/mongodb-connection-string).

Connection string must be placed in `application.properties` `spring.data.mongodb.uri` then in `spring.data.mongodb.uri` specify desired database and into `server.port` locally running port.

### Get information about movies and users.

```
GET/POST http://localhost:8080/api/employees 
GET/POST http://localhost:8080/api/wishes
POST     http://localhost:8080/api/assign
GET      http://localhost:8080/api/schedule?date={date}
```

### GET all employees 

```
GET /api/employees 
Accept: application/json
Content-Type: application/json

curl command:
curl http://localhost:8080/api/employees -H "Content-Type: application/json"

[
  {
    "id": "685d7d0a4e46e2548f5619f2",
    "name": "Alice"
  },
  {
    "id": "685d7d0b4e46e2548f5619f3",
    "name": "Bob"
  },
  {
    "id": "685d7d0b4e46e2548f5619f4",
    "name": "Carol"
  }
]

RESPONSE: HTTP 200 (OK)
```

### POST employees 

```
POST /api/employees 
Accept: application/json
Content-Type: application/json

curl command:
curl -X POST http://localhost:8080/api/employees -H "Content-Type: application/json" -d "{\"name\":\"Emily\"}"

{
	"id": "685ebece22e59d1e06343309",
	"name": "Emily"
}

RESPONSE: HTTP 201 (CREATED)
```


