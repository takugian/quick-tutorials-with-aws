package com.awsquickstarts;

import java.util.concurrent.CompletableFuture;

import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.S3Object;

public class ListObjectsV2 {

    public static void main(String[] args) throws Exception {
        final String accessKeyId = System.getenv("ACCESS_KEY_ID");
        final String secretAccessId = System.getenv("SECRET_ACCESS_KEY");
        final S3AsyncClient s3AsyncClient = new S3Service(accessKeyId, secretAccessId).getS3AsyncClient();
        listObjectsV2(s3AsyncClient);
    }

    private static void listObjectsV2(final S3AsyncClient s3AsyncClient) {
        System.out.println("Running listObjectsV2...");
        try {
            ListObjectsV2Request request = ListObjectsV2Request.builder()
                    .bucket("tg-public-bucket-123456")
                    .maxKeys(5)
                    // .prefix(null)
                    .build();
            CompletableFuture<ListObjectsV2Response> future = s3AsyncClient.listObjectsV2(request);
            ListObjectsV2Response response = future.get();
            for (S3Object object : response.contents()) {
                System.out.println(object.key());
            }
            System.out.println("listObjectsV2 has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}