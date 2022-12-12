# autoscalingelasticachereplicationgroup

This project creates an Auto Scaling for an ElastiCache Node Groups and Replicas.

## Pre requirements

- Create AWSServiceRoleForApplicationAutoScaling_RDSCluster IAM role
    - aws iam create-service-linked-role --aws-service-name elasticache.application-autoscaling.amazonaws.com

## Helpful links

- [Amazon ElastiCache][1]
- [Amazon ElastiCache for Redis Auto Scaling][2]

[1]: https://aws.amazon.com/elasticache/?nc1=h_ls
[2]: https://aws.amazon.com/elasticache/redis/auto-scaling/