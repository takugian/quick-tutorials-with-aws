package com.awsquickstarts;

import java.util.concurrent.CompletableFuture;

import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;

public class DeleteObject {

    public static void main(String[] args) throws Exception {
        final String accessKeyId = System.getenv("ACCESS_KEY_ID");
        final String secretAccessId = System.getenv("SECRET_ACCESS_KEY");
        final S3AsyncClient s3AsyncClient = new S3Service(accessKeyId, secretAccessId).getS3AsyncClient();
        deleteObject(s3AsyncClient);
    }

    private static void deleteObject(final S3AsyncClient s3AsyncClient) {
        System.out.println("Running deleteObject...");
        try {
            DeleteObjectRequest request = DeleteObjectRequest.builder()
                    .bucket("tg-public-bucket-123456")
                    .key("file1.txt")
                    .build();
            CompletableFuture<DeleteObjectResponse> future = s3AsyncClient.deleteObject(request);
            DeleteObjectResponse response = future.get();
            System.out.println(response);
            System.out.println("deleteObject has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}