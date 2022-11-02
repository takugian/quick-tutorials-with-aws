# apigatewayapikeyusageplan

This project creates a REST API Gateway with usage plan and API Key configured.

## How to invoke

```
curl -v --header "x-api-key: {x-api-key}" https://{restapi_id}.execute-api.{region}.amazonaws.com/{stage_name}/customers
```

- {x-api-key}: it is the value of the property ApiKey.Value defined in the cloudformation template file;
- {restapi_id}: it is the API identifier. Find it in API Gateway's console,
- {region}: is the Region, and
- {stage_name} is the stage name of the API deployment.

## Helpful links

- [What is Amazon API Gateway?][1]
- [Working with REST APIs][2]
- [Creating and using usage plans with API keys][3]

[1]: https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html
[2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-rest-api.html
[3]: https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-api-usage-plans.html