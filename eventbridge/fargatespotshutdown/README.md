# fargatespotshutdown

This project creates an Event Bridge rule with the folllowing events from a cluster using Fargate Spot:
    - Termination notice of a task;
    - Placement failure of a task;
- Two SNS Topics to receive the events

## Helpful links

- [What Is Amazon EventBridge?][1]
- [How do I handle Spot termination notices in AWS Fargate Spot tasks?][2]
- [What is Amazon SNS?][3]

[1]: https://docs.aws.amazon.com/eventbridge/latest/userguide/eb-what-is.html
[2]: https://aws.amazon.com/premiumsupport/knowledge-center/fargate-spot-termination-notice/?nc1=h_ls
[3]: https://docs.aws.amazon.com/sns/latest/dg/welcome.html