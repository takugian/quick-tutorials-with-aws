package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;

public class DeleteItem {

    public static void main(String[] args) throws Exception {
        final String accessKeyId = System.getenv("ACCESS_KEY_ID");
        final String secretAccessId = System.getenv("SECRET_ACCESS_KEY");
        final DynamoDbClient dynamoDbClient = new DynamoDbService(accessKeyId, secretAccessId).getDynamoDbClient();
        deleteItem(dynamoDbClient);
    }

    private static void deleteItem(final DynamoDbClient dynamoDbClient) {
        System.out.println("Running delete item...");
        try {
            final AttributeValue personDocumentNumber = AttributeValue.builder().s("111222333").build();
            final AttributeValue personBirthCountry = AttributeValue.builder().s("ISRAEL").build();
            final DeleteItemRequest request = DeleteItemRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .key(Map.of("person_document_number", personDocumentNumber, "person_birth_country",
                            personBirthCountry))
                    .build();
            dynamoDbClient.deleteItem(request);
            System.out.println("Delete item has completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}