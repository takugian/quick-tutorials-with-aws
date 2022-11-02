# apigatewaychatroomwebsocket

This project creates:
- A WebSocket API Gateway;
    - $connect route enabled;
        - Authorizer enabled;
    - $disconnect route enabled;
    - onMessage route enabled;
- A Lambda function as the backend of the API
    - CloudWatch Logs enabled;

## How to invoke

```
npm install -g wscat
```

Install wscat

```
wscat -c wss://{api_id}.execute-api.{region}.amazonaws.com/{stage_name}?authorizationToken={token}
```

- {api_id}: it is the API identifier. Find it in API Gateway's console,
- {region}: is the Region,
- {stage_name} is the stage name of the API deployment, and
- {token}: authorization token
    - If token's value is allow, the API will return a success response;
    - If token's value is deny, the API will return 403 Forbidden;
    - If you do not send this header, the API will return 401 Unauthorized;
    - If you send an invalid value, the API will return 500 Internal Server Error;

Create some connects to the WebSocket using at least two terminals and send message according to the example below:

```
{ "action": "onMessage": "message": "[YOUR MESSAGE]" }
```

## Helpful links

- [What is Amazon API Gateway?][1]
- [Working with WebSocket APIs][2]
- [Use wscat to connect to a WebSocket API and send messages to it][3]

[1]: https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html
[2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api.html
[3]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-how-to-call-websocket-api-wscat.html