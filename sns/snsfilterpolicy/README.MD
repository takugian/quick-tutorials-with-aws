# snsfilterpolicy

This project creates:
- A SNS Topic with subscription filter applied;

## How to test

Go to SNS console and send some messages. Use the panel "Message Attributes"
    - Examples of messages:
        - To send only to Queue1: { "status": "approved" }
        - To send only to Queue2: { "status": "rejected" }

## Helpful links

- [What is Amazon SNS?][1]
- [Fanout to Amazon SQS queues][2]

[1]: https://docs.aws.amazon.com/sns/latest/dg/welcome.html
[2]: https://docs.aws.amazon.com/sns/latest/dg/sns-sqs-as-subscriber.html