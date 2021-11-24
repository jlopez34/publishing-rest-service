# publishing-rest-service
API - REST created to show articles publishing recently about Java on Hacker News

This is the API-REST is thinks to be a simple control of papers published about Java language. The service provides to 
possibility of get the publishes made by The Hacker News. The post obtained by API-REST are saved in a database also 
it's possible to remove the papers that does not relevance for our research.

This repository contains a project which it was implemented below Spring Boot as main structure, MongoDB as database and
Gradle as a build automation.

## Implementation

### Technology:

Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".

We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. 
Most Spring Boot applications need minimal Spring configuration.


### EndPoints:
| Http Method  | Endpoint | Description |
| ------------- | ------------- |-----------|
| GET       | http://localhost:8090/news              | Return all papers returned by hacker news service but that It hasn't been removed|
| GET       | http://localhost:8090/news/service-test | Validate the hacker news service up|
| DELETE    | http://localhost:8090/news/{id}         | Remove papers by id|

* Swagger Documentation : [https://github.com/jlopez34/publishing-rest-service/blob/master/env/ingerencia-challenge.postman_collection.json][https://github.com/jlopez34/publishing-rest-service/blob/master/env/ingerencia-challenge.postman_collection.json]

### Features

* Returning all papers registered on The Hacker News 

* Execute the new service  each hour in background

* All papers obtained by The Hacker News service are saved in the local database (MongoDB)

* Possibility of remove paper does not relevance.

### Next Feature

* Using Docker or Kubernetes to make build of project.
* Implementing of the unit test and integration test necessaries to the project.


### Structure Package
```
com.ingerencia.rest.publishing 
  - config  ---> package used to access to properties resource and schedule job. 
  - controller --> package used to expose endpoints
  - model --> package used to group file like dto/model
  - exception --> package to create customer exception and handler exceptions
  - gateway --> package used to access to thrid-party service
  - repository --> package used to implement access to MongoDB database
  - service --> package content to logic implementation (core)
Publishing Application
```
### Requirements

Solution must use
* `Java 8`
* `Gradle`
* `Mockito`
* `Spring Boot 2.5.7`


### Build and Tests
#### Build

1. You should to make clone project [https://github.com/jlopez34/publishing-rest-service][https://github.com/jlopez34/publishing-rest-service]
2. Run `./gradlew clean build`
3. Run `./gradlew bootRun`   
3. Download Postman Collection:

#### Test
Run `./gradlew test` to run the unit tests. These should all pass if your solution has been implemented correctly.<br>
**Please** check that all the unit tests pass when you run `./gradlew clean test`, rather than solely running them from inside your IDE.

[https://github.com/jlopez34/publishing-rest-service]: https://github.com/jlopez34/publishing-rest-service

[https://github.com/jlopez34/publishing-rest-service/blob/master/env/ingerencia-challenge.postman_collection.json]: https://github.com/jlopez34/publishing-rest-service/blob/master/env/ingerencia-challenge.postman_collection.json


