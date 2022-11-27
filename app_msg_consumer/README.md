# AMQP consumer on Spring

This app reads messages from the queue in RabbitMQ using AMQP. 

## Overview of technology stack
This project is written using Spring framework. Maven is used to build the project and Java 17 as JDK.

## Docker
The docker image for this app is available in [docker hub](https://hub.docker.com/repository/docker/mcflydesigner/tv-lab-5-aqmp-consumer).

The project build consists of 2 stages (multistage build) and described in `./Dockerfile`.


## How to run?
* You should have pre-installed JDK(Java 17) and Maven 3.8.6.
* Navigate to working dir ```/app_msg_consumer```
* Run unit tests
```shell
mvn test
```
* Build application as ```.jar```
```shell
mvn clean install
```
* Run app using already built ```.jar``` file
```shell
java -jar ./target/consumer-app-0.0.1-SNAPSHOT.jar
```

* The server will be started by default on port 8085. 

* Great! Everything works!

## Endpoints
### Monitoring

Monitoring is performed with the use of Prometheus.

Main URL: `/actuator/prometheus`
Healthcheck URL: `/healthcheck`

## Contribution
You can contribute to our project - we are glad to new ideas. Just open pull requests.

## Credits
This project is developed by [@mcflydesigner](https://github.com/mcflydesigner) 

## License
The project is released and distributed under [MIT License](https://en.wikipedia.org/wiki/MIT_License).