package com.awsquickstarts.testmskecs.deliveryapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsquickstarts.testmskecs.common.exception.BusinessException;
import com.awsquickstarts.testmskecs.common.to.ErrorTo;
import com.awsquickstarts.testmskecs.deliveryapplication.service.DeliveryService;
import com.awsquickstarts.testmskecs.deliveryapplication.to.DeliveryTo;

@RestController
@RequestMapping(path = "/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<Object> getDeliveries() {

        try {

            final List<DeliveryTo> deliveries = this.deliveryService.findAll();

            return new ResponseEntity<Object>(deliveries, null, HttpStatusCode.valueOf(200));

        } catch (BusinessException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(400));
        } catch (Exception e) {
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(500));
        }

    }

}
