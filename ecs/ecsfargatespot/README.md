# ecsfargatespot

This project creates an ECS App using NodeJS using cluster with Fargate Spot compatibility enabled.

## Helpful links

- [What is Amazon Elastic Container Service?][1]
- [What is AWS Fargate?][2]
- [AWS Fargate Spot Now Generally Available][3]

[1]: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/Welcome.html
[2]: https://docs.aws.amazon.com/AmazonECS/latest/userguide/what-is-fargate.html
[3]: https://aws.amazon.com/pt/blogs/aws/aws-fargate-spot-now-generally-available/

## Pre requirements

- Repository created in Amazon ECR;

## How to deploy

### Local

```
npm start
```

#### How to test

- curl http://localhost:3070/healthcheck

### Docker

```
docker build -t ecsfargatespot .
docker images
docker run -d -p 3070:3070 --name ecsfargatespot ecsfargatespot
```

#### How to test

- curl http://localhost:3070/healthcheck

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

#### How to test

Find the public IP following ECS -> Cluster created > Service created > Configuration and tasks tab > Task running

- curl http://{TaskPublicIP}:3070/healthcheck

Check out CloudWatch console and wait for SIGTERM event