package com.takugian.ecsappjava.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/")
    public ResponseEntity<Object> getCustomers() {

        System.out.println("running /");

        return new ResponseEntity<>(null, HttpStatus.OK);

    }

}
