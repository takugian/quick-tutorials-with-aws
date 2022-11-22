package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;

public class GetItem {

    public static void main(String[] args) throws Exception {
        final String accessKeyId = System.getenv("ACCESS_KEY_ID");
        final String secretAccessId = System.getenv("SECRET_ACCESS_KEY");
        final DynamoDbClient dynamoDbClient = new DynamoDbService(accessKeyId, secretAccessId).getDynamoDbClient();
        query(dynamoDbClient);
    }

    private static void query(final DynamoDbClient dynamoDbClient) {
        System.out.println("Running get item...");
        try {
            final GetItemRequest request = GetItemRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .projectionExpression(
                            "person_document_number,person_birth_country,person_name,person_gender,person_age,person_birth_date")
                    .key(
                        Map.of("person_document_number", AttributeValue.builder().s("784778234").build()
                            , "person_birth_country", AttributeValue.builder().s("BRAZIL").build()))
                    .build();
            System.out.println(PersonDynamoDBUtil.convertItem(dynamoDbClient.getItem(request).item()));
            System.out.println("Get item has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}