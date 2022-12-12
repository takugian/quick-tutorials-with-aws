# autoscalingecs

This project creates an auto Scaling for an ECS task.

## Pre requirements

- Create AWSServiceRoleForApplicationAutoScaling_RDSCluster IAM role
    - aws iam create-service-linked-role --aws-service-name ecs.application-autoscaling.amazonaws.com

## Helpful links

- [What is Amazon Elastic Container Service?][1]
- [Auto Scaling groups][2]

[1]: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/Welcome.html
[2]: https://docs.aws.amazon.com/autoscaling/ec2/userguide/AutoScalingGroup.html