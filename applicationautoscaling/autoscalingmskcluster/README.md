# autoscalingmskcluster

This project creates an Auto Scaling for a MSK Cluster.

## Pre requirements

- Create AWSServiceRoleForApplicationAutoScaling_RDSCluster IAM role
    - aws iam create-service-linked-role --aws-service-name kafka.application-autoscaling.amazonaws.com

## Helpful links

- [Amazon Managed Streaming for Apache Kafka (MSK)][1]
- [Automatic scaling][2]

[1]: https://aws.amazon.com/pt/msk/
[2]: https://docs.aws.amazon.com/msk/latest/developerguide/msk-autoexpand.html