package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;

public class Query {

    public static void main(String[] args) throws Exception {
        final String accessKeyId = System.getenv("ACCESS_KEY_ID");
        final String secretAccessId = System.getenv("SECRET_ACCESS_KEY");
        final DynamoDbClient dynamoDbClient = new DynamoDbService(accessKeyId, secretAccessId).getDynamoDbClient();
        query(dynamoDbClient);
    }

    private static void query(final DynamoDbClient dynamoDbClient) {
        System.out.println("Running query...");
        try {
            final QueryRequest request = QueryRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .projectionExpression(
                            "person_document_number,person_birth_country,person_name,person_gender,person_age,person_birth_date")
                    .keyConditionExpression("person_document_number = :person_document_number")
                    .expressionAttributeValues(
                            Map.of(":person_document_number", AttributeValue.builder().s("784778234").build()))
                    .build();

            for (Map<String, AttributeValue> item : dynamoDbClient.queryPaginator(request).items()) {
                System.out.println(PersonDynamoDBUtil.convertItem(item));
            }
            System.out.println("Query has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // private static void getItem(final DynamoDbClient client, final Person
    // customer) {

    // System.out.println("Getting data:");

    // try {

    // final AttributeValue customer_id =
    // AttributeValue.builder().s(customer.getCustomerId()).build();
    // final AttributeValue birth_at =
    // AttributeValue.builder().s(customer.getBirthAt().toString()).build();

    // final GetItemRequest request = GetItemRequest.builder()
    // .tableName(TABLE_NAME)
    // .key(Map.of("customer_id", customer_id, "birth_at", birth_at))
    // .build();

    // final GetItemResponse response = client.getItem(request);

    // System.out.println(response.item());

    // } catch (Exception e) {
    // System.err.println("Unable to get item:");
    // e.printStackTrace();
    // }

    // }

}