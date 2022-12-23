package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;

public class GetItem {

    public static void main(String[] args) throws Exception {
        getItem();
    }

    private static void getItem() {
        System.out.println("running getItem...");
        try {
            final GetItemRequest request = GetItemRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .key(
                            Map.of("pk", AttributeValue.builder().s("MOVIE#DieHard").build(),
                                    "sk", AttributeValue.builder().s("MOVIE#DieHard").build()))
                    .build();
            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            PersonDynamoDBUtil.printItem(dynamoDbClient.getItem(request).item());
            System.out.println("getItem has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}