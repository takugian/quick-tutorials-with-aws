# autoscalinglambda

This project creates an Auto Scaling for a Lambda provisioned concurrency.

## Pre requirements

- Create AWSServiceRoleForApplicationAutoScaling_RDSCluster IAM role
    - aws iam create-service-linked-role --aws-service-name lambda.application-autoscaling.amazonaws.com

## Helpful links

- [What is AWS Lambda?][1]
- [AWS Lambda and Application Auto Scaling][2]

[1]: https://docs.aws.amazon.com/lambda/latest/dg/welcome.html
[2]: https://docs.aws.amazon.com/autoscaling/application/userguide/services-that-can-integrate-lambda.html