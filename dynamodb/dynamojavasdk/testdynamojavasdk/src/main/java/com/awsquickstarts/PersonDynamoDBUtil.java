package com.awsquickstarts;

import java.util.Map;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class PersonDynamoDBUtil {

    public static void printItem(final Map<String, AttributeValue> item) {

        final StringBuilder str = new StringBuilder();

        for (String itemKey : item.keySet()) {            
            final AttributeValue attributeValue = item.get(itemKey);            
            str.append(itemKey).append("=").append(getValue(attributeValue)).append(" ");
        }

        System.out.println(str);

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
