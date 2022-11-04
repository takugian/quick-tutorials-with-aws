# loadbalancerlistenerrules

This project creates an Application Load Balancer with listener rules configured.

## How to test

### Foward to Lambda1

curl --location --request GET 'LbLBWithListenerRules-1219335383.us-east-2.elb.amazonaws.com:80/customers?customer_type=PREMIUM' \
--header 'X-User: User1' \
--header 'Cookie: cookies'

### Foward to Lambda2

curl --location --request DELETE 'LbLBWithListenerRules-1219335383.us-east-2.elb.amazonaws.com:80/orders?customer_type=COMMUM' \
--header 'X-User: User2' \
--header 'Cookie: cookies'

## Helpful links

- [What is an Application Load Balancer?][1]
- [What is AWS Lambda?][2]

[1]: https://docs.aws.amazon.com/elasticloadbalancing/latest/application/introduction.html
[2]: https://docs.aws.amazon.com/lambda/latest/dg/welcome.html