# dynamostreamlambda

This project creates a DynamoDB Stream integrated with a Lambda function.

## How to test

You need to create some items to test. Only items with customer_number equals to 123456789 or items with customer_country_birth equals to BRAZIL will trigger the event to the Lambda function.

## Helpful links

- [What Is Amazon DynamoDB?][1]
- [Change Data Capture for DynamoDB Streams][2]
- [What is AWS Lambda?][3]

[1]: https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Introduction.html
[2]: https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Streams.html
[3]: https://docs.aws.amazon.com/lambda/latest/dg/welcome.html