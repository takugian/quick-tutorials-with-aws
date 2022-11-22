package com.awsquickstarts;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class DynamoDbService {

    private final String accessKeyId;
    
    private final String secretAccessId;

    public final static String TABLE_NAME = "Person";

    public DynamoDbService(String accessKeyId, String secretAccessId) {
        this.accessKeyId = accessKeyId;
        this.secretAccessId = secretAccessId;
    }

    public DynamoDbClient getDynamoDbClient() {

        final DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKeyId, secretAccessId)))
                .build();

        return dynamoDbClient;

    }

}
