# dynamotableecsapp

This project creates a DynamoDB Table and an ECS task to consume the DynamoDB Table using AWS SDK.

## Pre requirements

- Repository created in Amazon ECR;

## How to deploy

### Local

```
In application.properties file, set LOCAL to the property env.name  
mvn spring-boot:run
```

#### How to test

- curl http://localhost:3071/games

### Docker

```
In application.properties file, set LOCAL to the property env.name
docker build -t testdynamotableecsapp .
docker images
docker run -d -p 3071:3071 --name testdynamotableecsapp testdynamotableecsapp
```

#### How to test

- curl http://localhost:3071/games

### AWS

1  - Create a Cloudformation's stack using template_dynamodb.yml file
- This stack will create the DynamoDB table

2 - AWS credentials configurations
```
aws configure
```

3 - Login to docker
```
aws ecr get-login-password --region {Region} | docker login --username AWS --password-stdin {AccountId}.dkr.ecr.{Region}.amazonaws.com 
```

4 - Build and list the docker images
```
In application.properties file, set AWS to the property env.name  
docker build -t testdynamotableecsapp .
docker images
```

5 - Tag docker image
```
docker tag {ImageId} {RepositoryURI}:v1
```

6 - Push docker image to ECR repository
```
docker push {RepositoryURI}:v1
```

7 - Create a Cloudformation's stack using template_ecsapp.yml file
- This stack will create the ECS task using the docker previously pushed

## How to invoke

List games
```
curl -v http://{public_ip}/games
```

Save game
```
curl --location --request POST 'http://{public_ip}/games' \
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
curl --location --request GET 'http://{public_ip}/games/{id}'
```

Update game
```
curl --location --request PUT 'http://{public_ip}/games/{id}' \
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
curl --location --request DELETE 'http://{public_ip}/games/{id}'
```

- {public_ip}: find it in ECS console > cluster > service > Configuration and tasks tab > ECS task

## Helpful links

- [What Is Amazon DynamoDB?][1]
- [What is Amazon Elastic Container Service?][1]
- [What is AWS Fargate?][2]

[1]: https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Introduction.html
[2]: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/Welcome.html
[3]: https://docs.aws.amazon.com/AmazonECS/latest/userguide/what-is-fargate.html