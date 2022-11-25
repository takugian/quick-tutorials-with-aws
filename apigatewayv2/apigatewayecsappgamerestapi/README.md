# apigatewayecsappgamerestapi

This project creates a complete CRUD REST API using CloudFront in front of an API Gateway, an ECS task as backend, a Lambda function as authorizer and a RDS MySQL.

## Pre requirements

- Repository created in Amazon ECR;

## How to deploy

### Local

```
mvn spring-boot:run
```

#### How to test

- curl http://localhost:3071/healthcheck
- curl http://localhost:3071/games

### Docker

```
docker build -t gameapi .
docker images
docker run -d -p 3071:3071 --name gameapi gameapi
```

#### How to test

- curl http://localhost:3071/games
- curl http://localhost:3071/customers

### AWS

1 - Create a Cloudformation's stack using template_1.yml file
- This stack will create the RDS instance

2 - Go to RDS console, find the database, click on it and check the tab called Connectivity & security. There is your endpoint.

3 - Go to application.properties file from Java project and update the variable {{Endpoint}}

4 - Credentials configurations
```
aws configure
```

5 - Login
```
aws ecr get-login-password --region {Region} | docker login --username AWS --password-stdin {AccountId}.dkr.ecr.{Region}.amazonaws.com 
```

6 - List docker images
```
docker images
```

7 - Tag docker image
```
docker tag {ImageId} {RepositoryURI}:v1
```

8 - Push docker image to ECR repository
```
docker push {RepositoryURI}:v1
```

9 - Create a Cloudformation's stack using template_2.yml file
- This stack will create the ECS task using the docker previously pushed

10 - Create a Cloudformation's stack using template_3.yml file
- This stack will create the Lambda authorizer

11 - Create a Cloudformation's stack using template_4.yml file
- This stack will create the API Gateway and the Load Balancer

12 - Create a Cloudformation's stack using template_5.yml file
- This stack will create the CloudFront

#### How to test

List games
```
curl -v https://{cloudfront_domain}/games
```

Save game
```
curl --location --request POST 'https://{cloudfront_domain}/games' \
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
curl --location --request GET 'https://{cloudfront_domain}/games/1' \
--header 'Authorization: allow'
```

Update game
```
curl --location --request PUT 'https://{cloudfront_domain}/dev/games/1' \
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
curl --location --request DELETE 'https://{cloudfront_domain}/games/1' \
--header 'Authorization: allow'
```

- {restapi_id}: it is the API identifier. Find it in API Gateway's console,
- {region}: is the Region, and
- {stage_name} is the stage name of the API deployment.

## Helpful links

- [What is Amazon API Gateway?][1]
- [Working with REST APIs][2]
- [What is AWS Lambda?][3]

[1]: https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html
[2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-rest-api.html
[3]: https://docs.aws.amazon.com/lambda/latest/dg/welcome.html