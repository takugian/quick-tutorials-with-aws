package com.awsquickstarts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.async.AsyncResponseTransformer;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

public class GetObject {

    public static void main(String[] args) throws Exception {
        final String accessKeyId = System.getenv("ACCESS_KEY_ID");
        final String secretAccessId = System.getenv("SECRET_ACCESS_KEY");
        final S3AsyncClient s3AsyncClient = new S3Service(accessKeyId, secretAccessId).getS3AsyncClient();
        getObject(s3AsyncClient);
    }

    private static void getObject(final S3AsyncClient s3AsyncClient) {
        System.out.println("Running getObject...");
        try {
            GetObjectRequest request = GetObjectRequest.builder()
                    .bucket("tg-public-bucket-123456")
                    .key("file1.txt")
                    .build();
            CompletableFuture<ResponseBytes<GetObjectResponse>> future = s3AsyncClient
                    .getObject(request, AsyncResponseTransformer.toBytes());
            ResponseBytes<GetObjectResponse> response = future.get();
            String text = new BufferedReader(
                    new InputStreamReader(response.asInputStream(), StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
            System.out.println("Content: " + text);
            System.out.println("getObject has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}