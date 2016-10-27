# MyRetail 

Modules:
- Spring Cloud Discovery Service using Eureka 
- Spring Cloud API Gateway using Zuul
- Products RESTful service using Spring Boot
- Mongo DB backend for persistence
- Maven docker plugin to build images
- docker-compose definition to run the whole solution


How to run this example :

```sh
## To build docker images
mvn clean install

## To list recently built docker images
docker images

##To start up all instances
docker-compose up

##To start a 2nd instance of products-service
docker-compose scale products-service=2
```

Once all the services are up, the following URLs will be available

Address | Description
--- | ---
http://localhost:8761 | Eureka service. It shoud show that two instances of products-service are registered
http://localhost:9090/products/status | Products service served by Zuul api gateway.

##Postman
Import Postman project for executing RESTful requests

```sh
myretail.postman_collection.json
```


