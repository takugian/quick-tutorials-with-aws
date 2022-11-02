package com.takugian.ecsappjava.model.to;

public class CustomersIdResponseTo {

    private CustomerTo data = new CustomerTo();

    public CustomersIdResponseTo() {

    }

    public CustomersIdResponseTo(CustomerTo data) {
        this.data = data;
    }

    public CustomerTo getData() {
        return data;
    }

}
