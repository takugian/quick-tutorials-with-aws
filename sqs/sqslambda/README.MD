# sqslambda

This project creates:
- A SQS Queue;
- A private Lambda function to produce messages to the queue using SQS SDK;
- A private Lambda function to consume messages from the queue using event sourcing mapping;
- A VPC Endpoint to allow the integration between the private Lambda functions and the SQS queue;

## How to invoke

Go to Lambda's console, find the producer function and configure a new event test.

Payload example:
```
{
  "QueueUrl": "{queue_url}",
  "MessageBody": "{message}"
}
```

- {queue_url}: URL of SQS queue and
- {message}: some message to test

Click on "Test". You can check the result using CloudWatch Logs' console. The Log Group is the name of the functions.

## Helpful links

- [What is Amazon Simple Queue Service?][1]

[1]: https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/welcome.html