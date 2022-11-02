package com.takugian.ecsappjava.model.to;

import java.util.ArrayList;
import java.util.List;

public class CustomersResponseTo {

    private List<CustomerTo> data = new ArrayList<>();

    public CustomersResponseTo() {
        
    }

    public CustomersResponseTo(List<CustomerTo> data) {
        this.data = data;
    }

    public List<CustomerTo> getData() {
        return data;
    }

}
