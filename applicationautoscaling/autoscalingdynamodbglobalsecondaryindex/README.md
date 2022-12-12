# autoscalingdynamodbtable

This project creates an auto Scaling for a DynamoDB Table.

## Pre requirements

- Create AWSServiceRoleForApplicationAutoScaling_RDSCluster IAM role
    - aws iam create-service-linked-role --aws-service-name dynamodb.application-autoscaling.amazonaws.com

## Helpful links

- [What Is Amazon DynamoDB?][1]
- [Managing Throughput Capacity Automatically with DynamoDB Auto Scaling][2]

[1]: https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Introduction.html
[2]: https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/AutoScaling.html