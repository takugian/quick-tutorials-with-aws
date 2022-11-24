package com.awsquickstarts;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

public class PutObject {

    public static void main(String[] args) throws Exception {
        final String accessKeyId = System.getenv("ACCESS_KEY_ID");
        final String secretAccessId = System.getenv("SECRET_ACCESS_KEY");
        final S3AsyncClient s3AsyncClient = new S3Service(accessKeyId, secretAccessId).getS3AsyncClient();
        putObject(s3AsyncClient);
    }

    private static void putObject(final S3AsyncClient s3AsyncClient) {
        System.out.println("Running putObject...");
        try {
            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket("tg-public-bucket-123456")
                    .key("file1.txt")
                    .build();
            Path path = Paths.get("s3\\s3javasdk\\file1.txt");
            CompletableFuture<PutObjectResponse> future = s3AsyncClient.putObject(request, path);
            PutObjectResponse response = future.get();
            System.out.println(response);
            System.out.println("putObject has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}