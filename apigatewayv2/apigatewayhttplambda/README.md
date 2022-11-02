# apigatewayhttplambda

This project creates:
- A HTTP API Gateway
    - CORS enabled;
    - One route configured;
    - Throttling limits configured;
- A Lambda function as the backend of the API
    - CloudWatch Logs enabled;

## How to invoke

```
curl -v https://{restapi_id}.execute-api.{region}.amazonaws.com/{stage_name}/customers
```

- {restapi_id}: it is the API identifier. Find it in API Gateway's console,
- {region}: is the Region, and
- {stage_name} is the stage name of the API deployment.

## Helpful links

- [What is Amazon API Gateway?][1]
- [Working with HTTP APIs][2]

[1]: https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html
[2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api.html