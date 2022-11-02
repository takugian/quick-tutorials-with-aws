# apigatewayprivateloadbalancer

This project creates a private REST API Gateway integrated with a Network Load Balancer and an ECS task.

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