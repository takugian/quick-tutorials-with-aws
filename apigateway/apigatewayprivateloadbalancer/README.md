# apigatewayprivateloadbalancer

This project creates:
- A private REST API Gateway;
    - Endpoints enabled:
        - GET /customers;
        - POST /customers;
        - GET /customers/{id};
        - PUT /customers/{id};
        - DELETE /customers/{id};
- An integration between an API and a Network Load Balancer;

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
- [Introducing Amazon API Gateway Private Endpoints][3]
- [What is a Network Load Balancer?][4]

[1]: https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html
[2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-rest-api.html
[3]: https://aws.amazon.com/blogs/compute/introducing-amazon-api-gateway-private-endpoints/
[4]: https://docs.aws.amazon.com/elasticloadbalancing/latest/network/introduction.html