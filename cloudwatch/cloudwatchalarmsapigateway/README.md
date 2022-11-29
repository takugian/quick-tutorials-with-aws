# cloudwatchalarmsapigateway

This project creates a CloudWatch Alarms for an API Gateway.

## How to invoke

To return a sucess (200 HTTP code)
```
curl -v https://{restapi_id}.execute-api.{region}.amazonaws.com/{stage_name}/customers?customer_type=NATURAL
```

To return a bad request (400 HTTP code)
```
curl -v https://{restapi_id}.execute-api.{region}.amazonaws.com/{stage_name}/customers
```

To return a internal server error (500 HTTP code)
```
curl -v https://{restapi_id}.execute-api.{region}.amazonaws.com/{stage_name}/customers?customer_type=XPTO
```

## Helpful links

- [What is Amazon CloudWatch?][1]
- [Using Amazon CloudWatch alarms][2]
- [What is Amazon API Gateway?][3]
- [Monitoring REST API execution with Amazon CloudWatch metrics][4]

[1]: https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/WhatIsCloudWatch.html
[2]: https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/AlarmThatSendsEmail.html
[3]: https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html
[4]: https://docs.aws.amazon.com/apigateway/latest/developerguide/monitoring-cloudwatch.html