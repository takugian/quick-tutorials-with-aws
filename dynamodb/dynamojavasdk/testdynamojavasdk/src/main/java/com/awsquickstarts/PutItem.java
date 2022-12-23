package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

public class PutItem {

    public static void main(String[] args) throws Exception {
        putItem_Movie();
        putItem_MovieDirector();
        putItem_MovieCharacter1();
        putItem_MovieCharacter2();
    }

    private static void putItem_Movie() {
        System.out.println("running putItem_Movie...");
        try {
            final AttributeValue pk = AttributeValue.builder().s("MOVIE#DieHard").build();
            final AttributeValue sk = AttributeValue.builder().s("MOVIE#DieHard").build();
            final AttributeValue type = AttributeValue.builder().s("movie").build();
            final AttributeValue gsi2pk = AttributeValue.builder().s("Action").build();
            final AttributeValue gsi2sk = AttributeValue.builder().n("1988").build();
            final AttributeValue year = AttributeValue.builder().n("1988").build();
            final AttributeValue budget = AttributeValue.builder().s("25-35MM").build();
            final AttributeValue boxOffice = AttributeValue.builder().s("140MM").build();
            final AttributeValue category = AttributeValue.builder().s("Action").build();
            PutItemRequest request = PutItemRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .item(Map.of("pk", pk, "sk",
                            sk, "type", type, "gsi2pk", gsi2pk, "gsi2sk", gsi2sk, "year", year, "budget",
                            budget, "boxOffice", boxOffice, "category", category))
                    .build();
            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            dynamoDbClient.putItem(request);
            System.out.println("putItem_Movie has completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void putItem_MovieDirector() {
        System.out.println("running putItem_MovieDirector...");
        try {
            final AttributeValue pk = AttributeValue.builder().s("MOVIE#DieHard").build();
            final AttributeValue sk = AttributeValue.builder().s("DIRECTOR#JohnMcTiernan").build();
            final AttributeValue type = AttributeValue.builder().s("director").build();
            final AttributeValue gsi1pk = AttributeValue.builder().s("DIRECTOR#JohnMcTiernan").build();
            final AttributeValue gsi1sk = AttributeValue.builder().s("MOVIE#DieHard").build();
            final AttributeValue name = AttributeValue.builder().s("John McTiernan").build();
            PutItemRequest request = PutItemRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .item(Map.of("pk", pk, "sk",
                            sk, "type", type, "gsi1pk", gsi1pk, "gsi1sk", gsi1sk, "name", name))
                    .build();
            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            dynamoDbClient.putItem(request);
            System.out.println("putItem_MovieDirector has completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void putItem_MovieCharacter1() {
        System.out.println("running putItem_MovieCharacter1...");
        try {
            final AttributeValue pk = AttributeValue.builder().s("MOVIE#DieHard").build();
            final AttributeValue sk = AttributeValue.builder().s("CHARACTER#JohnMcClane").build();
            final AttributeValue type = AttributeValue.builder().s("character").build();
            final AttributeValue gsi1pk = AttributeValue.builder().s("CHARACTER#JohnMcClane").build();
            final AttributeValue gsi1sk = AttributeValue.builder().s("MOVIE#DieHard").build();
            final AttributeValue characterRole = AttributeValue.builder().s("protagonist").build();
            final AttributeValue playedBy = AttributeValue.builder().s("Bruce Willis").build();
            final AttributeValue name = AttributeValue.builder().s("John McClane").build();
            final AttributeValue nationality = AttributeValue.builder().s("Irish-American").build();
            PutItemRequest request = PutItemRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .item(Map.of("pk", pk, "sk",
                            sk, "type", type, "gsi1pk", gsi1pk, "gsi1sk", gsi1sk, "characterRole", characterRole,
                            "playedBy", playedBy,
                            "name", name, "nationality",
                            nationality))
                    .build();
            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            dynamoDbClient.putItem(request);
            System.out.println("putItem_MovieCharacter1 has completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void putItem_MovieCharacter2() {
        System.out.println("running putItem_MovieCharacter2...");
        try {
            final AttributeValue pk = AttributeValue.builder().s("MOVIE#DieHard").build();
            final AttributeValue sk = AttributeValue.builder().s("CHARACTER#HansGruber").build();
            final AttributeValue type = AttributeValue.builder().s("character").build();
            final AttributeValue gsi1pk = AttributeValue.builder().s("CHARACTER#HansGruber").build();
            final AttributeValue gsi1sk = AttributeValue.builder().s("MOVIE#DieHard").build();
            final AttributeValue characterRole = AttributeValue.builder().s("antagonist").build();
            final AttributeValue playedBy = AttributeValue.builder().s("Alan Rickman").build();
            final AttributeValue name = AttributeValue.builder().s("Hans Gruber").build();
            final AttributeValue alias = AttributeValue.builder().s("Bill Clay").build();
            final AttributeValue nationality = AttributeValue.builder().s("German").build();
            PutItemRequest request = PutItemRequest.builder()
                    .tableName(DynamoDbService.TABLE_NAME)
                    .item(Map.of("pk", pk, "sk",
                            sk, "type", type, "gsi1pk", gsi1pk, "gsi1sk", gsi1sk, "characterRole", characterRole,
                            "playedBy", playedBy,
                            "name", name, "alias", alias,
                            "nationality",
                            nationality))
                    .build();
            final DynamoDbClient dynamoDbClient = new DynamoDbService().getDynamoDbClient();
            dynamoDbClient.putItem(request);
            System.out.println("putItem_MovieCharacter2 has completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}