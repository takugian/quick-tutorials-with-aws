# cloudwatchalarmslambda

This project creates a CloudWatch Alarms for a Lambda function.

## Execute Lambda function asynchronously 

```
aws lambda invoke \
    --function-name ${FunctionName} \
    --invocation-type Event \
    --payload '{}' \
    response.json
```

## Helpful links

- [What is Amazon CloudWatch?][1]
- [Using Amazon CloudWatch alarms][2]
- [What is AWS Lambda?][3]
- [Working with Lambda function metrics][4]

[1]: https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/WhatIsCloudWatch.html
[2]: https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/AlarmThatSendsEmail.html
[3]: https://docs.aws.amazon.com/lambda/latest/dg/welcome.html
[4]: https://docs.aws.amazon.com/lambda/latest/dg/monitoring-metrics.html