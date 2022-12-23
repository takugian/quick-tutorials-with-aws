package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

public class PaginationScan {

    public static void main(String[] args) throws Exception {
        scan();
    }

    private static void scan() {
        System.out.println("running scan with pagination...");
        try {
            Map<String, AttributeValue> lastEvaluatedKey = null;
            while (true) {
                final ScanRequest request = ScanRequest.builder()
                        .tableName(DynamoDbService.TABLE_NAME)
                        // .indexName("")
                        .limit(2)
                        .exclusiveStartKey(lastEvaluatedKey)
                        .build();
                final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
                final ScanResponse scanResponse = dynamoDbClient.scan(request);
                lastEvaluatedKey = scanResponse.lastEvaluatedKey();
                for (Map<String, AttributeValue> item : dynamoDbClient.scan(request).items()) {
                    PersonDynamoDBUtil.printItem(item);
                }
                if (lastEvaluatedKey.isEmpty()) {
                    break;
                }
            }
            System.out.println("scan with pagination has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}