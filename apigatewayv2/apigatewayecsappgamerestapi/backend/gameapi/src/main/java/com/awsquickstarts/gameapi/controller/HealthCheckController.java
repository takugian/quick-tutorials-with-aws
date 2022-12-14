package com.awsquickstarts.gameapi.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<Object> healthCheck() {
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

}
