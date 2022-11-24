package com.awsquickstarts;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3AsyncClient;

public class S3Service {

    private final String accessKeyId;

    private final String secretAccessId;

    public S3Service(String accessKeyId, String secretAccessId) {
        this.accessKeyId = accessKeyId;
        this.secretAccessId = secretAccessId;
    }

    public S3AsyncClient getS3AsyncClient() {

        return S3AsyncClient.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKeyId, secretAccessId)))
                .build();

    }

}
