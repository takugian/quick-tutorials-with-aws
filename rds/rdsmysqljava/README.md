# rdsmysqljava

This project creates a RDS DB Instance inside a VPC using MySQL engine and a Java project to test SQL commands.

## How to test

- Go to RDS console, find the database, click on it and check the tab called Connectivity & security. There is your endpoint.
- Go to application.properties file from Java project and update the variable {{Endpoint}}
- Go to the class TestrdsmysqljavaApplication and run the project
- Check the log to see the integration working 

## Helpful links

- [What is Amazon Relational Database Service (Amazon RDS)?][1]

[1]: https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html