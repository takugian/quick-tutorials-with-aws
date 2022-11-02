package com.awsquickstarts;

import java.time.LocalDate;

public class Customer {

    private String customerId;

    private LocalDate birthAt;

    private String documentNumber;

    public Customer(String customerId, LocalDate birthAt, String documentNumber) {
        this.customerId = customerId;
        this.birthAt = birthAt;
        this.documentNumber = documentNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LocalDate getBirthAt() {
        return birthAt;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

}