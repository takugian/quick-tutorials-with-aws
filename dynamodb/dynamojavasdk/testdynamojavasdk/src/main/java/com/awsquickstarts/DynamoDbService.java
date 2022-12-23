package com.awsquickstarts;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class DynamoDbService {

    private final String accessKeyId;
    
    private final String secretAccessId;

    public final static String TABLE_NAME = "primary";

    public final static String INDEX_1_NAME = "gsi1";

    public final static String INDEX_2_NAME = "gsi2";

    public DynamoDbService() {
        this.accessKeyId = System.getenv("ACCESS_KEY_ID");
        this.secretAccessId = System.getenv("SECRET_ACCESS_KEY");
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
