package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class PersonDynamoDBUtil {

    public static Person convertItem(final Map<String, AttributeValue> item) {

        final Person person = new Person();

        for (String itemKey : item.keySet()) {

            final AttributeValue attributeValue = item.get(itemKey);

            if (itemKey == "person_document_number") {
                person.setPersonDocumentNumber(getValue(attributeValue));
            } else if (itemKey == "person_birth_country") {
                person.setPersonBirthCountry(getValue(attributeValue));
            } else if (itemKey == "person_name") {
                person.setPersonName(getValue(attributeValue));
            } else if (itemKey == "person_gender") {
                person.setPersonGender(getValue(attributeValue));
            } else if (itemKey == "person_age") {
                person.setPersonAge(Integer.valueOf(getValue(attributeValue)));
            } else if (itemKey == "person_birth_date") {
                person.setPersonBirthDate(getValue(attributeValue));
            } else if (itemKey == "person_create_date") {
                person.setPersonCreateDate(getValue(attributeValue));
            }
        }

        return person;

    }

    private static String getValue(final AttributeValue attributeValue) {
        if (attributeValue.s() != null) {
            return attributeValue.s();
        } else if (attributeValue.n() != null) {
            return attributeValue.n();
        }
        throw new IllegalArgumentException("Attribute type not mapped");
    }

}
