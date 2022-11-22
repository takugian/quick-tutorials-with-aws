package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

public class Scan {

    public static void main(String[] args) throws Exception {
        final String accessKeyId = System.getenv("ACCESS_KEY_ID");
        final String secretAccessId = System.getenv("SECRET_ACCESS_KEY");
        final DynamoDbClient dynamoDbClient = new DynamoDbService(accessKeyId, secretAccessId).getDynamoDbClient();
        scan(dynamoDbClient);
    }

    private static void scan(final DynamoDbClient dynamoDbClient) {
        System.out.println("Running scan...");
        try {
            final ScanRequest request = ScanRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .projectionExpression(
                            "person_document_number,person_birth_country,person_name,person_gender,person_age,person_birth_date")
                    .filterExpression("#person_gender = :person_gender")
                    .expressionAttributeNames(Map.of("#person_gender", "person_gender"))
                    .expressionAttributeValues(Map.of(":person_gender", AttributeValue.builder().s("FEMALE").build()))
                    .build();
            for (Map<String, AttributeValue> item : dynamoDbClient.scan(request).items()) {
                System.out.println(PersonDynamoDBUtil.convertItem(item));
            }
            System.out.println("Scan has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}