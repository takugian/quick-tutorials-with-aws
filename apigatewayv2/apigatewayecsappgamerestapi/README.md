# apigatewayecsappgamerestapi

This project creates a complete CRUD REST API using an API Gateway, an ECS task as backend, a Lambda function as authorizer and a RDS MySQL.

## Pre requirements

- Repository created in Amazon ECR;

## How to deploy

### Local

```
mvn spring-boot:run
```

#### How to test

- curl http://localhost:3071/dev/games

### Docker

```
docker build -t gameapi .
docker images
docker run -d -p 3071:3071 --name gameapi gameapi
```

#### How to test

- curl http://localhost:3071/dev/games

### AWS

``Opcional. Only if you want to integrate to RDS. Default is H2 database``
1  - Create a Cloudformation's stack using template_rds.yml file
- This stack will create the RDS instance
- After stack is complete, find the database using RDS console, click on it and check the tab called Connectivity & security. There is your endpoint
- Go to application.properties file from Java project and update the variable {{Endpoint}}

2 - Create a Cloudformation's stack using template_vpc_link.yml file
- This stack will create the VPC Link

3 - Create a Cloudformation's stack using template_lambda_authorizer.yml file
- This stack will create the Lambda Authorizer

4 - Create a Cloudformation's stack using template_load_balancer.yml file
- This stack will create the Load Balancer

5 - AWS credentials configurations
```
aws configure
```

6 - Login to docker
```
aws ecr get-login-password --region {Region} | docker login --username AWS --password-stdin {AccountId}.dkr.ecr.{Region}.amazonaws.com 
```

7 - Build and list the docker images
```
docker build -t gameapi .
docker images
```

8 - Tag docker image
```
docker tag {ImageId} {RepositoryURI}:v1
```

9 - Push docker image to ECR repository
```
docker push {RepositoryURI}:v1
```

10 - Create a Cloudformation's stack using template_ecs.yml file
- This stack will create the ECS task using the docker previously pushed

11 - Create a Cloudformation's stack using template_api_gateway.yml file
- This stack will create the API Gateway

#### How to test

List games
```
curl -v https://{gateway_domain}/dev/games
```

Save game
```
curl --location --request POST 'https://{gateway_domain}/dev/games' \
--header 'Authorization: allow' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "THE LAST OF US PART I",
    "platform": "PS5",
    "company": "SONY",
    "developer": "NAUGHTY DOG"
}'
```

Find game
```
curl --location --request GET 'https://{gateway_domain}/dev/games/1' \
--header 'Authorization: allow'
```

Update game
```
curl --location --request PUT 'https://{gateway_domain}/dev/games/1' \
--header 'Authorization: allow' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "THE LAST OF US PART I",
    "platform": "PS5 PLUS",
    "company": "SON",
    "developer": "NAUGHTY DOG"
}'
```

Delete game
```
curl --location --request DELETE 'https://{gateway_domain}/dev/games/1' \
--header 'Authorization: allow'
```

## Helpful links

- [What is Amazon API Gateway?][1]
- [Working with REST APIs][2]
- [Use API Gateway Lambda authorizers][3]
- [What is AWS Lambda?][4]
- [What is Amazon Elastic Container Service?][5]
- [What is AWS Fargate?][6]
- [What is a Network Load Balancer?][7]
- [What is Amazon Elastic Container Service?][8]
- [What is Amazon Relational Database Service (Amazon RDS)?][9]

[1]: https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html
[2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-rest-api.html
[3]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-use-lambda-authorizer.html
[4]: https://docs.aws.amazon.com/lambda/latest/dg/welcome.html
[5]: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/Welcome.html
[6]: https://docs.aws.amazon.com/AmazonECS/latest/userguide/what-is-fargate.html
[7]: https://docs.aws.amazon.com/elasticloadbalancing/latest/network/introduction.html
[8]: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/Welcome.html
[9]: https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html