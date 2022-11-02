# staticwebsiteapigatewayhttpwebsocket

This project creates:
- A S3 Bucket used as a static website that consumes a websocket;
- A websocket API Gateway;
    - $default route enabled;
    - $connect route enabled;
    - $disconnect route enabled;

## How to invoke

Edit the file /website/index.html and update the websocket URL on line 10

Upload the files index.html and error.html of website directory

Use the website URL returned as output of the cloudformation execution to test the integration with the websocket

## Helpful links

- [What is Amazon S3?][1]
- [Hosting a static website using Amazon S3][2]
- [What is Amazon API Gateway?][3]
- [Working with WebSocket APIs][4]
- [Use wscat to connect to a WebSocket API and send messages to it][5]

[1]: https://docs.aws.amazon.com/AmazonS3/latest/userguide/Welcome.html
[2]: https://docs.aws.amazon.com/AmazonS3/latest/userguide/WebsiteHosting.html
[3]: https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html
[4]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api.html
[5]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-how-to-call-websocket-api-wscat.html