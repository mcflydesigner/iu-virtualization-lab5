# Deployment to k8s

The `./deploy.yml` file contains the following definitions to deploy `PostgreSQL`, `RabbitMQ`, 
`app-message-producer`, `app-message-consumer`:
* `postgres-secret` - secrets for `PostgreSQL`(username, password)
* `rabbitmq-secret` - secrets for `RabbitMQ`(username, password)
* `rabbitmq` - statefulset for `RabbitMQ` deployment 
* `rabbitmq-service` - service for `RabbitMQ` 
* `postgres` - statefulset for `PostgreSQL` deployment
* `postgres-service` - service for `RabbitMQ`
* `app-msg-producer-deployment` - deployment of message producer Java app 
* `app-msg-producer-java-service` - service for message producer Java app 
* `app-msg-producer-deployment` - deployment of message producer Java app
* `app-msg-producer-java-service` - service for message producer Java app 

## How to deploy?
Run the following command:
```shell
kubectl apply -f ./deploy.yml
```
