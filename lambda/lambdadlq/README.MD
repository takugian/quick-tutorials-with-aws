# lambdadlq

This project creates:
- A Lambda function with DLQ config;

## Execute Lambda function asynchronously 

```
aws lambda invoke \
    --function-name ${FunctionName} \
    --invocation-type Event \
    --payload '{}' \
    response.json
```

## Helpful links

- [What is AWS Lambda?][1]
- [Amazon SQS dead-letter queues][2]

[1]: https://docs.aws.amazon.com/lambda/latest/dg/welcome.html
[2]: https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-dead-letter-queues.html