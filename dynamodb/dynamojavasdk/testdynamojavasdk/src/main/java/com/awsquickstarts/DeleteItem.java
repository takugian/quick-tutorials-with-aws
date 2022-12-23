package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;

public class DeleteItem {

    public static void main(String[] args) throws Exception {
        deleteItem();
    }

    private static void deleteItem() {
        System.out.println("running deleteItemm...");
        try {
            final AttributeValue pk = AttributeValue.builder().s("MOVIE#DieHard").build();
            final AttributeValue sk = AttributeValue.builder().s("MOVIE#DieHard").build();
            final DeleteItemRequest request = DeleteItemRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .key(Map.of("pk", pk, "sk", sk))
                    .build();
            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            dynamoDbClient.deleteItem(request);
            System.out.println("deleteItem has completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}