# autoscalingauroracluster

This project creates an Auto Scaling for an Aurora Cluster.

## Pre requirements

- Create AWSServiceRoleForApplicationAutoScaling_RDSCluster IAM role
    - aws iam create-service-linked-role --aws-service-name rds.application-autoscaling.amazonaws.com

## Helpful links

- [What is Amazon Aurora?][1]
- [Managing performance and scaling for Aurora DB clusters][2]

[1]: https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/CHAP_AuroraOverview.html
[2]: https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/Aurora.Managing.Performance.html