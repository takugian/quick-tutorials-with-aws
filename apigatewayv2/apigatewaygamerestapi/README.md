# apigatewaygamerestapi

This project creates a complete CRUD REST API using an API Gateway, a Lambda function as backend, a Lambda function as authorizer and a DynamoDB table.

## How to invoke

List games
```
curl -v https://{restapi_id}.execute-api.{region}.amazonaws.com/{stage_name}/games
```

Save game
```
curl --location --request POST 'https://pursvt5pcg.execute-api.us-east-2.amazonaws.com/dev/games' \
--header 'Authorization: allow' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "THE LAST OF US PART I",
    "platform": "PS5",
    "company": "SONY",
    "developer": "NAUGHTY DOG"
}'
```

Find game
```
curl --location --request GET 'https://pursvt5pcg.execute-api.us-east-2.amazonaws.com/dev/games/1' \
--header 'Authorization: allow'
```

Update game
```
curl --location --request PUT 'https://pursvt5pcg.execute-api.us-east-2.amazonaws.com/dev/games/1' \
--header 'Authorization: allow' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "THE LAST OF US PART I",
    "platform": "PS5 PLUS",
    "company": "SON",
    "developer": "NAUGHTY DOG"
}'
```

Delete game
```
curl --location --request DELETE 'https://pursvt5pcg.execute-api.us-east-2.amazonaws.com/dev/games/1' \
--header 'Authorization: allow'
```

- {restapi_id}: it is the API identifier. Find it in API Gateway's console,
- {region}: is the Region, and
- {stage_name} is the stage name of the API deployment.

## Helpful links

- [What is Amazon API Gateway?][1]
- [Working with REST APIs][2]
- [What is AWS Lambda?][3]

[1]: https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html
[2]: https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-rest-api.html
[3]: https://docs.aws.amazon.com/lambda/latest/dg/welcome.html