package com.awsquickstarts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.WriteRequest;

public class TestDynamoDB {

    private final static String ACCESS_KEY_ID = "";
    private final static String SECRET_ACCESS_ID = "";

    private final static String TABLE_NAME = "Customer";

    public static void main(String[] args) throws Exception {

        final DynamoDbClient ddbClient = DynamoDbClient.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(ACCESS_KEY_ID, SECRET_ACCESS_ID)))
                .build();

        final Customer customer = new Customer(
                "565c64e0-07ac-4eaf-80a4-a74342dc7824", LocalDate.of(1991, 11, 28), "67588932091");

        final List<Customer> customerBatch = Arrays.asList(
                new Customer(
                        "c1e7b800-cb7e-47a9-bb0c-f2bd97eaed1f", LocalDate.of(1991, 5, 5), "68398032544"),
                new Customer(
                        "cfbadfed-845a-4bc4-a945-1cb48fbd1aaf", LocalDate.of(1967, 6, 10), "45566678209"),
                new Customer(
                        "093fafba-e59f-4c05-8c89-7409dffbcfa1", LocalDate.of(1984, 12, 10), "10376010060"));

        writeData(ddbClient, customer);
        writeBatchData(ddbClient, customerBatch);
        getItem(ddbClient, customer);
        query(ddbClient, customer);
        scan(ddbClient, customer);
        deleteItem(ddbClient, customer);

    }

    private static void writeData(final DynamoDbClient client, final Customer customer) {

        System.out.println("Writing data...");

        try {

            final AttributeValue customer_id = AttributeValue.builder().s(customer.getCustomerId())
                    .build();
            final AttributeValue birth_at = AttributeValue.builder().s(customer.getBirthAt().toString()).build();
            final AttributeValue document_number = AttributeValue.builder().s(customer.getDocumentNumber()).build();

            PutItemRequest request = PutItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .item(Map.of("customer_id", customer_id, "birth_at", birth_at, "document_number", document_number))
                    .build();

            client.putItem(request);

        } catch (Exception e) {
            System.err.println("Unable to write item:");
            e.printStackTrace();
        }

    }

    private static void writeBatchData(final DynamoDbClient client, final List<Customer> customerBatch) {

        System.out.println("Writing batch data...");

        try {

            final List<WriteRequest> writeItems = new ArrayList<>();
            for (Customer customer : customerBatch) {
                final AttributeValue customer_id = AttributeValue.builder().s(customer.getCustomerId()).build();
                final AttributeValue birth_at = AttributeValue.builder().s(customer.getBirthAt().toString()).build();
                final AttributeValue document_number = AttributeValue.builder().s(customer.getDocumentNumber()).build();
                final WriteRequest writeRequest = WriteRequest.builder()
                        .putRequest(PutRequest.builder()
                                .item(
                                        Map.of(
                                                "customer_id", customer_id,
                                                "birth_at", birth_at,
                                                "document_number", document_number))
                                .build())
                        .build();
                writeItems.add(writeRequest);
            }

            final Map<String, List<WriteRequest>> items = new HashMap<>();
            items.put(TABLE_NAME, writeItems);

            BatchWriteItemRequest request = BatchWriteItemRequest.builder()
                    .requestItems(items).build();

            client.batchWriteItem(request);

        } catch (Exception e) {
            System.err.println("Unable to write batch:");
            e.printStackTrace();
        }

    }

    private static void getItem(final DynamoDbClient client, final Customer customer) {

        System.out.println("Getting data:");

        try {

            final AttributeValue customer_id = AttributeValue.builder().s(customer.getCustomerId()).build();
            final AttributeValue birth_at = AttributeValue.builder().s(customer.getBirthAt().toString()).build();

            final GetItemRequest request = GetItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .key(Map.of("customer_id", customer_id, "birth_at", birth_at))
                    .build();

            final GetItemResponse response = client.getItem(request);

            System.out.println(response.item());

        } catch (Exception e) {
            System.err.println("Unable to get item:");
            e.printStackTrace();
        }

    }

    private static void query(final DynamoDbClient client, final Customer customer) {

        System.out.println("Quering data:");

        try {

            final String keyConditionExpression = "customer_id = :customer_id";
            final AttributeValue customer_id = AttributeValue.builder().s(customer.getCustomerId()).build();

            final QueryRequest request = QueryRequest.builder()
                    .tableName(TABLE_NAME)
                    .keyConditionExpression(keyConditionExpression)
                    .expressionAttributeValues(
                            Map.of(":customer_id", customer_id))
                    .build();

            for (Map<String, AttributeValue> item : client.queryPaginator(request).items()) {
                System.out.println(item);
            }

        } catch (Exception e) {
            System.err.println("Unable to query table:");
            e.printStackTrace();
        }

    }

    private static void scan(final DynamoDbClient client, final Customer customer) {

        System.out.println("Scanning data:");

        try {

            final ScanRequest request = ScanRequest.builder()
                    .tableName(TABLE_NAME)
                    .build();

            for (Map<String, AttributeValue> item : client.scan(request).items()) {
                System.out.println(item);
            }

        } catch (Exception e) {
            System.err.println("Unable to scan table:");
            e.printStackTrace();
        }

    }

    private static void deleteItem(final DynamoDbClient client, final Customer customer) {

        System.out.println("Deleting data:");

        try {

            final AttributeValue customer_id = AttributeValue.builder().s(customer.getCustomerId()).build();
            final AttributeValue birth_at = AttributeValue.builder().s(customer.getBirthAt().toString()).build();

            final DeleteItemRequest request = DeleteItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .key(Map.of("customer_id", customer_id, "birth_at", birth_at))
                    .build();

            client.deleteItem(request);

        } catch (Exception e) {
            System.err.println("Unable to delete data:");
            e.printStackTrace();
        }

    }

}