# ecsappautoscaling

This project creates:
- ECS App using NodeJS
    - Auto Scaling configured;
    - CloudWatch Logs enabled;
    - Fargate compatibility;
    - Public IP address enabled;

## Helpful links

- [What is Amazon Elastic Container Service?][1]
- [What is AWS Fargate?][2]
- [Auto Scaling groups][3]

[1]: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/Welcome.html
[2]: https://docs.aws.amazon.com/AmazonECS/latest/userguide/what-is-fargate.html
[3]: https://docs.aws.amazon.com/autoscaling/ec2/userguide/AutoScalingGroup.html

## Pre requirements

- Repository created in Amazon ECR;

## How to deploy

### Local

```
npm start
```

#### How to test

- curl http://localhost:3070/healthcheck
- curl http://localhost:3070/customers

### Docker

```
docker build -t ecsappnode .
docker images
docker run -d -p 3070:3070 --name ecsappnode ecsappnode
```

#### How to test

- curl http://localhost:3070/healthcheck
- curl http://localhost:3070/customers

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
- curl http://{TaskPublicIP}:3070/customers