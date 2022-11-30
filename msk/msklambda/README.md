# msklambda

This project creates a MSK Cluster and a Lambda to consume a Kafka topics.

## Pre requirements

- Repository created in Amazon ECR;

## How to deploy

### Kafka

Run docker-compose.yml
```
version: '2'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
    ports:
      - 22181:2181
  
  kafka:
    image: confluentinc/cp-kafka:latest
    depends_on:
      - zookeeper
    ports:
      - 29092:29092
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092,PLAINTEXT_HOST://localhost:29092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1

```

### Local

```
In application.properties file, set spring.kafka.bootstrap-servers=localhost:29092
mvn spring-boot:run
```

#### How to test

```
Save a sale
curl --location --request POST 'http://localhost:3071/sales' \
--header 'Content-Type: application/json' \
--data-raw '{
    "sale_shop_id": "string",
    "sale_customer_id": "string",
    "sale_value": number,
    "sale_date": "YYYY-MM-DD"
}'
```

```
Check application logs to see the producer and the consumer working.
```

### Docker

```
In application.properties file, set spring.kafka.bootstrap-servers=localhost:29092
docker build -t testmskecs .
docker images
docker run -d -p 3071:3071 --name testmskecs testmskecs
```

#### How to test

```
Save a sale
curl --location --request POST 'http://localhost:3071/sales' \
--header 'Content-Type: application/json' \
--data-raw '{
    "sale_shop_id": "string",
    "sale_customer_id": "string",
    "sale_value": number,
    "sale_date": "YYYY-MM-DD"
}'
```

```
Check application logs to see the producer and the consumer working.
```

### AWS

1  - Create a Cloudformation's stack using template_msk.yml file
- This stack will create the MSK cluster

2 - Set spring.kafka.bootstrap-servers
```
In application.properties file, set spring.kafka.bootstrap-servers equals to dns:port from MSK console
```

3 - AWS credentials configurations
```
aws configure
```

4 - Login to docker
```
aws ecr get-login-password --region {Region} | docker login --username AWS --password-stdin {AccountId}.dkr.ecr.{Region}.amazonaws.com 
```

5 - Build and list the docker images
```
In application.properties file, set AWS to the property env.name  
docker build -t testmskecs .
docker images
```

6 - Tag docker image
```
docker tag {ImageId} {RepositoryURI}:v1
```

7 - Push docker image to ECR repository
```
docker push {RepositoryURI}:v1
```

8 - Create a Cloudformation's stack using template_ecsapp.yml file
- This stack will create the ECS task using the docker previously pushed

## How to invoke

```
Save a sale
curl --location --request POST 'http://{{public_ip}}:3071/sales' \
--header 'Content-Type: application/json' \
--data-raw '{
    "sale_shop_id": "string",
    "sale_customer_id": "string",
    "sale_value": number,
    "sale_date": "YYYY-MM-DD"
}'
```

- {public_ip}: find it in ECS console > cluster > service > Configuration and tasks tab > ECS task

```
Check application logs on CloudWatch console > Log group to see the producer and the consumer working.
```

## Helpful links

- [Amazon Managed Streaming for Apache Kafka (MSK)][1]

[1]: https://aws.amazon.com/pt/msk/