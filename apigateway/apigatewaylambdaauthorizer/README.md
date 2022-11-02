# apigatewaylambdaauthorizer

This project creates:
- A REST API Gateway;
    - Authorizer enabled;
- A Lambda function as authorizer of the API
    - CloudWatch Logs enabled;
- A Lambda function as backend of the API
    - CloudWatch Logs enabled;

## How to invoke

```
curl -v --header "authorizationToken: {token}" https://{restapi_id}.execute-api.{region}.amazonaws.com/{stage_name}/customers
```

- {token}: authorization token
    - If token's value is allow, the API will return a success response;
    - If token's value is deny, the API will return 403 Forbidden;
    - If you do not send this header, the API will return 401 Unauthorized;
    - If you send an invalid value, the API will return 500 Internal Server Error;
- {restapi_id}: it is the API identifier. Find it in API Gateway's console,
- {region}: is the Region, and
- {stage_name} is the stage name of the API deployment.

## Helpful links

- [What is Amazon API Gateway?][1]
- [Working with REST APIs][2]
- [Use API Gateway Lambda authorizers][3]

[1]: https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html
[2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api.html
[3]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-use-lambda-authorizer.html