# codecommitrepository

This project creates:
- A CodeCommit Repository that triggers events to a SNS topic;

## Pre requirements

- Zip all files of lambda folder;
    - buildspec.yml and index.js must be in the root;
- Upload the zip according to the bucket and bucket key defined in the cloudformation template;

## Helpful links

- [What is AWS CodeCommit?][1]
- [What is AWS Lambda?][2]
- [What is Amazon SNS?][3]

[1]: https://docs.aws.amazon.com/codecommit/latest/userguide/welcome.html
[2]: https://docs.aws.amazon.com/lambda/latest/dg/welcome.html
[3]: https://docs.aws.amazon.com/sns/latest/dg/welcome.html