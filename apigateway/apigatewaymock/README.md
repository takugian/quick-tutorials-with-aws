# apigatewaymock

This project creates:
- A REST API Gateway with a mocked backend;

## How to invoke

```
curl -v https://{restapi_id}.execute-api.{region}.amazonaws.com/{stage_name}/customers
```

- {restapi_id}: it is the API identifier. Find it in API Gateway's console,
- {region}: is the Region, and
- {stage_name} is the stage name of the API deployment.

## Helpful links

- [What is Amazon API Gateway?][1]
- [Working with REST APIs][2]
- [Set up mock integrations in API Gateway][3]

[1]: https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html
[2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-rest-api.html
[3]: https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-mock-integration.html