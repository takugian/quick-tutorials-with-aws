package com.awsquickstarts.testmskecs.deliveryapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.awsquickstarts.testmskecs.common.exception.BusinessException;
import com.awsquickstarts.testmskecs.deliveryapplication.to.DeliveryTo;
import com.awsquickstarts.testmskecs.saleapplication.to.SaleTo;

@Service
public class DeliveryService {

    private CountDownLatch latch = new CountDownLatch(1);

    private List<DeliveryTo> deliveries = new ArrayList<>();

    public List<DeliveryTo> findAll() {
        return this.deliveries;
    }

    @KafkaListener(topics = "sale_has_completed", containerFactory = "saleKafkaListenerContainerFactory")
    public void consumeSaleHasCompleted(final SaleTo sale) {

        System.out.println("Consuming the event 'sale has completed");

        latch.countDown();

        System.out.println("Event 'sale has completed' has consumed");

        this.save(new DeliveryTo(null, sale.getSaleId()));

    }

    private DeliveryTo save(final DeliveryTo delivery) {

        System.out.println("Saving delivery");

        if (!StringUtils.hasText(delivery.getSaleId())) {
            throw new BusinessException("sale_id is required");
        }

        delivery.setDeliveryId(String.valueOf(new Random().nextInt()));

        this.deliveries.add(delivery);

        System.out.println("Delivery has saved");

        return delivery;

    }

}
