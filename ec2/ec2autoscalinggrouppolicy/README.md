# ec2autoscalinggrouppolicy

This project creates:
- An IAM Instance Profile for launch template;
- An EC2 launch template used by ASG;
- An Auto Scaling Group (ASG);
- Four types of Auto Scaling Policies:
    - Predictive scaling;
    - Target tracking scaling;
    - Step scaling policy;
    - Simple scaling;
- An EC2 Instance to test the ASG;

## Helpful links

- [What is Amazon EC2?][1]
- [Auto Scaling groups][2]
- [Predictive scaling for Amazon EC2 Auto Scaling][3]
- [Target tracking scaling policies for Amazon EC2 Auto Scaling][4]
- [Step and simple scaling policies for Amazon EC2 Auto Scaling][5]

[1]: https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts.html
[2]: https://docs.aws.amazon.com/autoscaling/ec2/userguide/AutoScalingGroup.html
[3]: https://docs.aws.amazon.com/autoscaling/ec2/userguide/ec2-auto-scaling-predictive-scaling.html
[4]: https://docs.aws.amazon.com/autoscaling/ec2/userguide/as-scaling-target-tracking.html
[5]: https://docs.aws.amazon.com/autoscaling/ec2/userguide/as-scaling-simple-step.html