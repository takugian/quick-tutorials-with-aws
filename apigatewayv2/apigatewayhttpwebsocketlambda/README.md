# apigatewayhttpwebsocketlambda

This project creates a WebSocket API Gateway integrated to a Lambda function.

## How to invoke

```
npm install -g wscat
```

Install wscat

```
wscat -c wss://{api_id}.execute-api.{region}.amazonaws.com/{stage_name}
```

- {api_id}: it is the API identifier. Find it in API Gateway's console,
- {region}: is the Region, and
- {stage_name} is the stage name of the API deployment.

Connect to the WebSocket and send message using JSON format

## Helpful links

- [What is Amazon API Gateway?][1]
- [Working with WebSocket APIs][2]
- [Use wscat to connect to a WebSocket API and send messages to it][3]

[1]: https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html
[2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api.html
[3]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-how-to-call-websocket-api-wscat.html