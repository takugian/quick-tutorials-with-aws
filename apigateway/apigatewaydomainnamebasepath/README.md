# apigatewaydomainnamebasepath

This project creates a REST API Gateway with domain name and base path.

## How to invoke

```
curl -v https://{domain_name}/{base_path}/customers
```

- {domain_name}: it is the domain name where the gateway was registered and 
- {base_path}: it is the base path configured for the API.

## Helpful links

- [What is Amazon API Gateway?][1]
- [Working with REST APIs][2]
- [Setting up custom domain names for REST APIs][3]
- [Using multiple segments in Amazon API Gateway base path mapping][4]
- [What Is AWS Certificate Manager?][5]

[1]: https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html
[2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-rest-api.html
[3]: https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-custom-domains.html
[4]: https://aws.amazon.com/pt/blogs/compute/using-multiple-segments-in-amazon-api-gateway-base-path-mapping/
[5]: https://docs.aws.amazon.com/acm/latest/userguide/acm-overview.html