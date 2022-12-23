package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;

public class Query {

    public static void main(String[] args) throws Exception {
        query_MovieDetail();
        query_MovieDirector();
        query_MovieCharacters();
        query_MoviesByDirector();
        query_MoviesByCharacterProtagonist();
        query_ActionMovies();
        query_ActionMoviesBeforeYear1989();
    }

    private static void query_MovieDetail() {
        System.out.println("running query_MovieDetail...");
        try {
            final QueryRequest request = QueryRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .keyConditionExpression("pk = :pk and sk = :sk")
                    .expressionAttributeValues(
                            Map.of(":pk", AttributeValue.builder().s("MOVIE#DieHard").build(), ":sk",
                                    AttributeValue.builder().s("MOVIE#DieHard").build()))
                    .build();

            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            for (Map<String, AttributeValue> item : dynamoDbClient.queryPaginator(request).items()) {
                PersonDynamoDBUtil.printItem(item);
            }
            System.out.println("query_MovieDetail has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void query_MovieDirector() {
        System.out.println("running query_MovieDirector...");
        try {
            final QueryRequest request = QueryRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .keyConditionExpression("pk = :pk and begins_with(sk, :sk)")
                    .expressionAttributeValues(
                            Map.of(":pk", AttributeValue.builder().s("MOVIE#DieHard").build(), ":sk",
                                    AttributeValue.builder().s("DIRECTOR#").build()))
                    .build();

            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            for (Map<String, AttributeValue> item : dynamoDbClient.queryPaginator(request).items()) {
                PersonDynamoDBUtil.printItem(item);
            }
            System.out.println("query_MovieDirector has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void query_MovieCharacters() {
        System.out.println("running query_MovieCharacters...");
        try {
            final QueryRequest request = QueryRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .keyConditionExpression("pk = :pk and begins_with(sk, :sk)")
                    .expressionAttributeValues(
                            Map.of(":pk", AttributeValue.builder().s("MOVIE#DieHard").build(), ":sk",
                                    AttributeValue.builder().s("CHARACTER#").build()))
                    .build();

            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            for (Map<String, AttributeValue> item : dynamoDbClient.queryPaginator(request).items()) {
                PersonDynamoDBUtil.printItem(item);
            }
            System.out.println("query_MovieCharacters has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void query_MoviesByDirector() {
        System.out.println("running query_MoviesByDirector...");
        try {
            final QueryRequest request = QueryRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .indexName(DynamoDbService.INDEX_1_NAME)
                    .keyConditionExpression("gsi1pk = :gsi1pk and begins_with(gsi1sk, :gsi1sk)")
                    .expressionAttributeValues(
                            Map.of(":gsi1pk", AttributeValue.builder().s("DIRECTOR#JohnMcTiernan").build(), ":gsi1sk",
                                    AttributeValue.builder().s("MOVIE#").build()))
                    .build();

            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            for (Map<String, AttributeValue> item : dynamoDbClient.queryPaginator(request).items()) {
                PersonDynamoDBUtil.printItem(item);
            }
            System.out.println("query_MoviesByDirector has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void query_MoviesByCharacterProtagonist() {
        System.out.println("running query_MoviesByCharacterProtagonist...");
        try {
            final QueryRequest request = QueryRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .indexName(DynamoDbService.INDEX_1_NAME)
                    .keyConditionExpression("gsi1pk = :gsi1pk and begins_with(gsi1sk, :gsi1sk)")
                    .filterExpression("characterRole = :characterRole")
                    .expressionAttributeValues(
                            Map.of(":gsi1pk", AttributeValue.builder().s("CHARACTER#JohnMcClane").build(), ":gsi1sk",
                                    AttributeValue.builder().s("MOVIE#").build(), ":characterRole",
                                    AttributeValue.builder().s("protagonist").build()))
                    .build();

            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            for (Map<String, AttributeValue> item : dynamoDbClient.queryPaginator(request).items()) {
                PersonDynamoDBUtil.printItem(item);
            }
            System.out.println("query_MoviesByCharacterProtagonist has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void query_ActionMovies() {
        System.out.println("running query_ActionMovies...");
        try {
            final QueryRequest request = QueryRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .indexName(DynamoDbService.INDEX_2_NAME)
                    .keyConditionExpression("gsi2pk = :gsi2pk")
                    .expressionAttributeValues(
                            Map.of(":gsi2pk", AttributeValue.builder().s("Action").build()))
                    .build();

            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            for (Map<String, AttributeValue> item : dynamoDbClient.queryPaginator(request).items()) {
                PersonDynamoDBUtil.printItem(item);
            }
            System.out.println("query_ActionMovies has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void query_ActionMoviesBeforeYear1989() {
        System.out.println("running query_ActionMoviesBeforeYear1989...");
        try {
            final QueryRequest request = QueryRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .indexName(DynamoDbService.INDEX_2_NAME)
                    .keyConditionExpression("gsi2pk = :gsi2pk and gsi2sk < :gsi2sk")
                    .expressionAttributeValues(
                            Map.of(":gsi2pk", AttributeValue.builder().s("Action").build(), ":gsi2sk",
                                    AttributeValue.builder().n("1989").build()))
                    .build();

            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            for (Map<String, AttributeValue> item : dynamoDbClient.queryPaginator(request).items()) {
                PersonDynamoDBUtil.printItem(item);
            }
            System.out.println("query_ActionMoviesBeforeYear1989 has completed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}