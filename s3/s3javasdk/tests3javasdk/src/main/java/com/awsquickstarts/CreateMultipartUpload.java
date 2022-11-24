package com.awsquickstarts;

import java.util.concurrent.CompletableFuture;

import software.amazon.awssdk.core.async.AsyncRequestBody;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadResponse;
import software.amazon.awssdk.services.s3.model.CompletedMultipartUpload;
import software.amazon.awssdk.services.s3.model.CompletedPart;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
import software.amazon.awssdk.services.s3.model.UploadPartResponse;

public class CreateMultipartUpload {

    public static void main(String[] args) throws Exception {
        final String accessKeyId = System.getenv("ACCESS_KEY_ID");
        final String secretAccessId = System.getenv("SECRET_ACCESS_KEY");
        final S3AsyncClient s3AsyncClient = new S3Service(accessKeyId, secretAccessId).getS3AsyncClient();
        createMultipartUpload(s3AsyncClient);
    }

    private static void createMultipartUpload(final S3AsyncClient s3AsyncClient) {
        System.out.println("Running createMultipartUpload...");
        try {

            final String BUCKET_NAME = "tg-public-bucket-123456";
            final String KEY = "file_complete.txt";
            final String CONTENT_PART_1 = "Hello, ";
            final String CONTENT_PART_2 = "I'm a complete file!";

            CreateMultipartUploadRequest createMultipartUploadRequest = CreateMultipartUploadRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(KEY)
                    .build();
            CompletableFuture<CreateMultipartUploadResponse> futureCreateMultipartUpload = s3AsyncClient
                    .createMultipartUpload(createMultipartUploadRequest);
            CreateMultipartUploadResponse createMultipartUploadResponse = futureCreateMultipartUpload.get();
            System.out.println("uploadId: " + createMultipartUploadResponse.uploadId());
            System.out.println("createMultipartUpload has created");

            UploadPartRequest uploadPartRequest1 = UploadPartRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(KEY)
                    .uploadId(createMultipartUploadResponse.uploadId())
                    .partNumber(1)
                    .contentLength((long) CONTENT_PART_1.getBytes().length)
                    .build();
            CompletableFuture<UploadPartResponse> futureUploadPart1 = s3AsyncClient.uploadPart(uploadPartRequest1,
                    AsyncRequestBody.fromString(CONTENT_PART_1));
            System.out.println(futureUploadPart1.get());
            System.out.println("parte 1 has uploaded");

            UploadPartRequest uploadPartRequest2 = UploadPartRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(KEY)
                    .uploadId(createMultipartUploadResponse.uploadId())
                    .partNumber(2)
                    .contentLength((long) CONTENT_PART_2.getBytes().length)
                    .build();
            CompletableFuture<UploadPartResponse> futureUploadPart2 = s3AsyncClient.uploadPart(uploadPartRequest2,
                    AsyncRequestBody.fromString(CONTENT_PART_2));
            System.out.println(futureUploadPart2.get());
            System.out.println("parte 2 has uploaded");

            CompletedPart completedPart1 = CompletedPart.builder().partNumber(1).build();
            CompletedPart completedPart2 = CompletedPart.builder().partNumber(2).build();
            CompletedMultipartUpload completedMultipartUpload = CompletedMultipartUpload.builder()
                    .parts(completedPart1, completedPart2)
                    .build();
            CompleteMultipartUploadRequest completeMultipartUploadRequest = CompleteMultipartUploadRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(KEY)
                    .uploadId(createMultipartUploadResponse.uploadId())
                    .multipartUpload(completedMultipartUpload)
                    .build();
            CompletableFuture<CompleteMultipartUploadResponse> futureCompleteMultipartUpload = s3AsyncClient
                    .completeMultipartUpload(completeMultipartUploadRequest);
            System.out.println(futureCompleteMultipartUpload.get());

            System.out.println("createMultipartUpload has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
