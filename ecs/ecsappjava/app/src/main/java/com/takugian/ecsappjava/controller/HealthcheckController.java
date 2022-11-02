package com.takugian.ecsappjava.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {

    @GetMapping("/healthcheck")
    public ResponseEntity<Object> getCustomers() {

        System.out.println("running /healthcheck");

        return new ResponseEntity<>(null, HttpStatus.OK);

    }

}
