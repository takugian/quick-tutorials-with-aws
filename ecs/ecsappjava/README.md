# ecsappjava

This project creates an ECS App with following features:
    - Java 11;
    - Docker
    - CloudWatch Logs enabled;
    - Fargate compatibility;
    - Health check enabled;
    - Placement stratregy 'spread';
    - Public IP address enabled;

## Pre requirements

- Repository created in Amazon ECR;

## How to deploy

### Local

```
mvn spring-boot:run
```

#### How to test

- curl http://localhost:3071/healthcheck
- curl http://localhost:3071/customers

### Docker

```
docker build -t ecsappjava .
docker images
docker run -d -p 3071:3071 --name ecsappjava ecsappjava
```

#### How to test

- curl http://localhost:3071/healthcheck
- curl http://localhost:3071/customers

### AWS

Credentials configurations
```
aws configure
```

Login
```
aws ecr get-login-password --region {Region} | docker login --username AWS --password-stdin {AccountId}.dkr.ecr.{Region}.amazonaws.com 
```

List docker images
```
docker images
```

Tag docker image
```
docker tag {ImageId} {RepositoryURI}:v1
```

Push docker image to ECR repository
```
docker push {RepositoryURI}:v1
```

```
Use Cloudformation to create the stack to deploy the ECS task
```

#### How to test

Find the public IP following ECS -> Cluster created > Service created > Configuration and tasks tab > Task running

- curl http://{TaskPublicIP}:3071/healthcheck
- curl http://{TaskPublicIP}:3071/customers

## Helpful links

- [What is Amazon Elastic Container Service?][1]
- [What is AWS Fargate?][2]

[1]: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/Welcome.html
[2]: https://docs.aws.amazon.com/AmazonECS/latest/userguide/what-is-fargate.html