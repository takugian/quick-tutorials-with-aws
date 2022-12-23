package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

public class Scan {

    public static void main(String[] args) throws Exception {
        scan();
    }

    private static void scan() {
        System.out.println("running scan...");
        try {
            final ScanRequest request = ScanRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    // .indexName("")
                    // .filterExpression("")
                    // .expressionAttributeValues(Map.of("",
                    // AttributeValue.builder().s("").build()))
                    .build();
            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            for (Map<String, AttributeValue> item : dynamoDbClient.scan(request).items()) {
                PersonDynamoDBUtil.printItem(item);
            }
            System.out.println("scan has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}