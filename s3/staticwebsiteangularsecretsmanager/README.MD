# staticwebsiteangularsecretsmanager

This project creates:
- A S3 Bucket used as a static website to deploy an AngularJS app;
- A secret using Secrets Manager to integrate to the app;

## AngularJS deploy

```
- ng build
```

Upload the files of dist directory which was created from ng build command

## Helpful links

- [What is Amazon S3?][1]
- [Hosting a static website using Amazon S3][2]
- [What is AWS Secrets Manager?][3]

[1]: https://docs.aws.amazon.com/AmazonS3/latest/userguide/Welcome.html
[2]: https://docs.aws.amazon.com/AmazonS3/latest/userguide/WebsiteHosting.html
[3]: https://docs.aws.amazon.com/secretsmanager/latest/userguide/intro.html