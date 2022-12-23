package com.awsquickstarts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutRequest;
import software.amazon.awssdk.services.dynamodb.model.WriteRequest;

public class BatchWriteItem {

    public static void main(String[] args) throws Exception {
        batchWriteItem();
    }

    private static void batchWriteItem() {
        System.out.println("running batchWriteItem...");
        try {

            final List<WriteRequest> writeItems = new ArrayList<>();

            writeItems.add(getWriteRequest1());
            writeItems.add(getWriteRequest2());
            writeItems.add(getWriteRequest3());

            final Map<String, List<WriteRequest>> items = new HashMap<>();
            items.put(DynamoDbService.TABLE_NAME, writeItems);
            BatchWriteItemRequest request = BatchWriteItemRequest.builder().requestItems(items).build();
            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            dynamoDbClient.batchWriteItem(request);
            System.out.println("batchWriteItem item has completed");
        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }

    private static WriteRequest getWriteRequest1() {

        final AttributeValue pk = AttributeValue.builder().s("MOVIE#DieHard2").build();
        final AttributeValue sk = AttributeValue.builder().s("MOVIE#DieHard2").build();
        final AttributeValue type = AttributeValue.builder().s("movie").build();
        final AttributeValue gsi2pk = AttributeValue.builder().s("Action").build();
        final AttributeValue gsi2sk = AttributeValue.builder().n("1990").build();
        final AttributeValue year = AttributeValue.builder().n("1990").build();
        final AttributeValue budget = AttributeValue.builder().s("62–70MM").build();
        final AttributeValue boxOffice = AttributeValue.builder().s("240MM").build();
        final AttributeValue category = AttributeValue.builder().s("Action").build();

        final WriteRequest writeRequest = WriteRequest.builder()
                .putRequest(PutRequest.builder()
                        .item(Map.of("pk", pk, "sk",
                                sk, "type", type, "gsi2pk", gsi2pk,
                                "gsi2sk",
                                gsi2sk, "year", year, "budget",
                                budget, "boxOffice", boxOffice, "category", category))
                        .build())
                .build();

        return writeRequest;

    }

    private static WriteRequest getWriteRequest2() {

        final AttributeValue pk = AttributeValue.builder().s("MOVIE#DieHard2").build();
        final AttributeValue sk = AttributeValue.builder().s("DIRECTOR#RennyHarlin").build();
        final AttributeValue type = AttributeValue.builder().s("director").build();
        final AttributeValue gsi1pk = AttributeValue.builder().s("DIRECTOR#RennyHarlin").build();
        final AttributeValue gsi1sk = AttributeValue.builder().s("MOVIE#DieHard2").build();
        final AttributeValue name = AttributeValue.builder().s("Renny Harlin").build();

        final WriteRequest writeRequest = WriteRequest.builder()
                .putRequest(PutRequest.builder()
                        .item(Map.of("pk", pk, "sk",
                                sk, "type", type, "gsi1pk", gsi1pk,
                                "gsi1sk",
                                gsi1sk, "name", name))
                        .build())
                .build();

        return writeRequest;

    }

    private static WriteRequest getWriteRequest3() {

        final AttributeValue pk = AttributeValue.builder().s("MOVIE#DieHard2").build();
        final AttributeValue sk = AttributeValue.builder().s("CHARACTER#JohnMcClane").build();
        final AttributeValue type = AttributeValue.builder().s("character").build();
        final AttributeValue gsi1pk = AttributeValue.builder().s("CHARACTER#JohnMcClane").build();
        final AttributeValue gsi1sk = AttributeValue.builder().s("MOVIE#DieHard2").build();
        final AttributeValue characterRole = AttributeValue.builder().s("protagonist").build();
        final AttributeValue playedBy = AttributeValue.builder().s("Bruce Willis").build();
        final AttributeValue nationality = AttributeValue.builder().s("Irish-American").build();
        final AttributeValue name = AttributeValue.builder().s("John McClane").build();

        final WriteRequest writeRequest = WriteRequest.builder()
                .putRequest(PutRequest.builder()
                        .item(Map.of("pk", pk, "sk",
                                sk, "type", type, "gsi1pk", gsi1pk,
                                "gsi1sk",
                                gsi1sk, "characterRole", characterRole, "playedBy",
                                playedBy, "nationality", nationality, "name", name))
                        .build())
                .build();

        return writeRequest;

    }

}