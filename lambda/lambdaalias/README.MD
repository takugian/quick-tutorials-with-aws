# lambdaalias

This project creates a Lambda function with versions and an alias with routing configuration.

## How to test

```
aws lambda invoke --function-name "{LambdaName}" --qualifier "{Version}" --log-type Tail C:\quick-tutorials-with-aws-cloud\outputfile.txt
```

```
aws lambda invoke --function-name "{LambdaName}" --qualifier "{Alias}" --log-type Tail C:\quick-tutorials-with-aws-cloud\outputfile.txt
```

## Helpful links

- [What is AWS Lambda?][1]
- [Lambda function versions][2]
- [Lambda function aliases][3]

[1]: https://docs.aws.amazon.com/lambda/latest/dg/welcome.html
[2]: https://docs.aws.amazon.com/lambda/latest/dg/configuration-versions.html
[3]: https://docs.aws.amazon.com/lambda/latest/dg/configuration-aliases.html