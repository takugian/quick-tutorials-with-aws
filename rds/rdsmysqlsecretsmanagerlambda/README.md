# rdsmysqlsecretsmanagerlambda

This project creates:
- A RDS DB Instance inside a VPC using MySQL engine
    - A Lambda function to connect to the table;
    - A VPC Endpoint to allow access to Secrets Manager from Lambda function;
    - Username and password for the database connection using Secrets Manager;

## Helpful links

- [What is Amazon Relational Database Service (Amazon RDS)?][1]
- [VPC endpoints][2]
- [What is AWS Secrets Manager?][3]

[1]: https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html
[2]: https://docs.aws.amazon.com/vpc/latest/privatelink/vpc-endpoints.html
[3]: https://docs.aws.amazon.com/secretsmanager/latest/userguide/intro.html