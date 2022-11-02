# stepfunctionscomplete

This project creates:
- Resources of the state machine: Lambdas, DynamoDB table and SQS queues;
- Step functions state machine;

## How to test

Example of payload to invoke step functions

```
{
    "requestId": "1",
    "customerId": "1"
  	"status": "SUCCESS",
}
```

## Helpful links

- [https://docs.aws.amazon.com/step-functions/latest/dg/welcome.html][1]
- [What is AWS Lambda?][2]
- [What Is Amazon DynamoDB?][3]
- [What is Amazon Simple Queue Service?][4]

[1]: https://docs.aws.amazon.com/step-functions/latest/dg/welcome.html
[2]: https://docs.aws.amazon.com/lambda/latest/dg/welcome.html
[3]: https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Introduction.html
[4]: https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/welcome.html