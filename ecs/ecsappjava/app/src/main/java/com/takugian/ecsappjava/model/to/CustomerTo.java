package com.takugian.ecsappjava.model.to;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerTo {

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("customer_birth_at")
    private String customerBirthAt;

    public CustomerTo() {

    }

    public CustomerTo(String customerId, String customerName, String customerBirthAt) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthAt = customerBirthAt;
    }

    @Override
    public String toString() {
        return "{" +
                " customerId='" + getCustomerId() + "'" +
                ", customerName='" + getCustomerName() + "'" +
                ", customerBirthAt='" + getCustomerBirthAt() + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerTo)) {
            return false;
        }
        CustomerTo customerTo = (CustomerTo) o;
        return Objects.equals(customerId, customerTo.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthAt() {
        return customerBirthAt;
    }

    public void setCustomerBirthAt(String customerBirthAt) {
        this.customerBirthAt = customerBirthAt;
    }

}
