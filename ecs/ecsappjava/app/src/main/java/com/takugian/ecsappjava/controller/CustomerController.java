package com.takugian.ecsappjava.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.takugian.ecsappjava.model.to.CustomerTo;
import com.takugian.ecsappjava.model.to.CustomersIdResponseTo;
import com.takugian.ecsappjava.model.to.CustomersResponseTo;
import com.takugian.ecsappjava.model.to.ErrorResponseTo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private static List<CustomerTo> customers = new ArrayList<>();

    @PostConstruct
    public void init() {
        customers.add(new CustomerTo("6c84fb90-12c4-11e1-840d-7b25c5ee775a", "EMERSON", "1993-01-22"));
    }

    @GetMapping("/customers")
    public ResponseEntity<CustomersResponseTo> getCustomers(
            @RequestParam(name = "customer_name", required = false) String customerName) {

        System.out.println(String.format("running GET /customers params [ customer_name = %s ]", customerName));

        if (customerName != null && customerName.length() != 0) {
            List<CustomerTo> result = customers.stream().filter(item -> item.getCustomerName().equals(customerName))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(new CustomersResponseTo(result), HttpStatus.OK);
        }

        return new ResponseEntity<>(new CustomersResponseTo(customers), HttpStatus.OK);

    }

    @PostMapping("/customers")
    public ResponseEntity<Object> postCustomers(@RequestBody CustomerTo customer) {

        System.out.println(String.format("running POST /customers body %s", customer));

        if (customer.getCustomerName() == null || customer.getCustomerName().length() == 0) {
            return new ResponseEntity<>(new ErrorResponseTo("1", "customer_name is required"), HttpStatus.BAD_REQUEST);
        }

        customer.setCustomerId(UUID.randomUUID().toString());

        customers.add(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", String.format("/customers/%s", customer.getCustomerId()));

        return new ResponseEntity<>(null, headers, HttpStatus.CREATED);

    }

    @GetMapping("/customers/{customer_id}")
    public ResponseEntity<CustomersIdResponseTo> getCustomersId(@PathVariable(name = "customer_id") String customerId) {

        System.out.println(String.format("running GET /customers/%s", customerId));

        final Optional<CustomerTo> result = customers.stream().filter(item -> item.getCustomerId().equals(customerId))
                .findFirst();

        if (result != null && result.isPresent()) {
            return new ResponseEntity<>(new CustomersIdResponseTo(result.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/customers/{customer_id}")
    public ResponseEntity<Object> putCustomersId(@PathVariable(name = "customer_id") String customerId,
            @RequestBody CustomerTo customer) {

        System.out.println(String.format("running PUT /customers/%s body %s", customerId, customer));

        customer.setCustomerId(customerId);

        final Optional<CustomerTo> result = customers.stream().filter(item -> item.getCustomerId().equals(customerId))
                .findFirst();

        if (result != null && result.isPresent()) {
            final CustomerTo customerUpdated = result.get();
            customerUpdated.setCustomerName(customer.getCustomerName());
            customerUpdated.setCustomerBirthAt(customer.getCustomerBirthAt());
            customers.remove(customer);
            customers.add(customerUpdated);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/customers/{customer_id}")
    public ResponseEntity<Object> deleteCustomersId(@PathVariable(name = "customer_id") String customerId) {

        System.out.println(String.format("running DELETE /customers/%s", customerId));

        final Optional<CustomerTo> result = customers.stream().filter(item -> item.getCustomerId().equals(customerId))
                .findFirst();

        if (result != null && result.isPresent()) {
            customers.remove(result.get());
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

}
