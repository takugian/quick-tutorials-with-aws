package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

public class PutItem {

    public static void main(String[] args) throws Exception {
        final String accessKeyId = System.getenv("ACCESS_KEY_ID");
        final String secretAccessId = System.getenv("SECRET_ACCESS_KEY");
        final DynamoDbClient dynamoDbClient = new DynamoDbService(accessKeyId, secretAccessId).getDynamoDbClient();
        putItem(dynamoDbClient);
    }

    private static void putItem(final DynamoDbClient dynamoDbClient) {
        System.out.println("Running put item...");
        try {
            final AttributeValue personDocumentNumber = AttributeValue.builder().s("111222333").build();
            final AttributeValue personBirthCountry = AttributeValue.builder().s("ISRAEL").build();
            final AttributeValue personName = AttributeValue.builder().s("MATUSALEM ETERNO").build();
            final AttributeValue personGender = AttributeValue.builder().s("MALE").build();
            final AttributeValue personAge = AttributeValue.builder().s("122").build();
            final AttributeValue personBirthDate = AttributeValue.builder().s("1900-01-01").build();
            final AttributeValue personCreateDate = AttributeValue.builder().s("2022-11-22").build();
            PutItemRequest request = PutItemRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .item(Map.of("person_document_number", personDocumentNumber, "person_birth_country",
                            personBirthCountry, "person_name", personName, "person_gender", personGender, "person_age",
                            personAge, "person_birth_date", personBirthDate, "person_create_date", personCreateDate))
                    .build();
            dynamoDbClient.putItem(request);
            System.out.println("Put item has completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}