package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

public class PaginationScan {

    public static void main(String[] args) throws Exception {
        final String accessKeyId = System.getenv("ACCESS_KEY_ID");
        final String secretAccessId = System.getenv("SECRET_ACCESS_KEY");
        final DynamoDbClient dynamoDbClient = new DynamoDbService(accessKeyId, secretAccessId).getDynamoDbClient();
        scan(dynamoDbClient);
    }

    private static void scan(final DynamoDbClient dynamoDbClient) {
        System.out.println("Running pagination scan...");
        try {
            Map<String, AttributeValue> lastEvaluatedKey = null;
            while (true) {
                final ScanRequest request = ScanRequest.builder()
                        .tableName(DynamoDbService.TABLE_NAME)
                        .limit(2)
                        .exclusiveStartKey(lastEvaluatedKey)
                        .build();
                final ScanResponse scanResponse = dynamoDbClient.scan(request);
                lastEvaluatedKey = scanResponse.lastEvaluatedKey();
                for (Map<String, AttributeValue> item : dynamoDbClient.scan(request).items()) {
                    System.out.println(PersonDynamoDBUtil.convertItem(item));
                }
                if (lastEvaluatedKey.isEmpty()) {
                    break;
                }
            }
            System.out.println("Pagination scan has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}