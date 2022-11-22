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
        final String accessKeyId = System.getenv("ACCESS_KEY_ID");
        final String secretAccessId = System.getenv("SECRET_ACCESS_KEY");
        final DynamoDbClient dynamoDbClient = new DynamoDbService(accessKeyId, secretAccessId).getDynamoDbClient();
        batchWriteItem(dynamoDbClient);
    }

    private static void batchWriteItem(final DynamoDbClient dynamoDbClient) {
        System.out.println("Running batch write item...");
        try {
            final List<WriteRequest> writeItems = new ArrayList<>();
            for (Person person : getPeople()) {

                final AttributeValue personDocumentNumber = AttributeValue.builder().s(person.getPersonDocumentNumber())
                        .build();
                final AttributeValue personBirthCountry = AttributeValue.builder().s(person.getPersonBirthCountry())
                        .build();
                final AttributeValue personName = AttributeValue.builder().s(person.getPersonName()).build();
                final AttributeValue personGender = AttributeValue.builder().s(person.getPersonGender()).build();
                final AttributeValue personAge = AttributeValue.builder().s(person.getPersonAge().toString()).build();
                final AttributeValue personBirthDate = AttributeValue.builder().s(person.getPersonBirthDate()).build();
                final AttributeValue personCreateDate = AttributeValue.builder().s(person.getPersonCreateDate())
                        .build();
                final WriteRequest writeRequest = WriteRequest.builder()
                        .putRequest(PutRequest.builder()
                                .item(Map.of("person_document_number", personDocumentNumber, "person_birth_country",
                                        personBirthCountry, "person_name", personName, "person_gender", personGender,
                                        "person_age",
                                        personAge, "person_birth_date", personBirthDate, "person_create_date",
                                        personCreateDate))
                                .build())
                        .build();
                writeItems.add(writeRequest);
            }
            final Map<String, List<WriteRequest>> items = new HashMap<>();
            items.put(DynamoDbService.TABLE_NAME, writeItems);
            BatchWriteItemRequest request = BatchWriteItemRequest.builder().requestItems(items).build();
            dynamoDbClient.batchWriteItem(request);
            System.out.println("Batch write item has completed");
        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Person> getPeople() {
        final List<Person> people = new ArrayList<>();
        Person person1 = new Person();
        person1.setPersonDocumentNumber("999555100");
        person1.setPersonBirthCountry("ENGLAND");
        person1.setPersonName("EDWARD SMITH");
        person1.setPersonGender("MALE");
        person1.setPersonAge(2);
        person1.setPersonBirthDate("2020-01-01");
        person1.setPersonCreateDate("2022-11-22");
        people.add(person1);
        Person person2 = new Person();
        person2.setPersonDocumentNumber("999555200");
        person2.setPersonBirthCountry("ENGLAND");
        person2.setPersonName("MARIA KENT");
        person2.setPersonGender("FEMALE");
        person2.setPersonAge(4);
        person2.setPersonBirthDate("2018-06-11");
        person2.setPersonCreateDate("2022-11-22");
        people.add(person2);
        return people;

    }

}