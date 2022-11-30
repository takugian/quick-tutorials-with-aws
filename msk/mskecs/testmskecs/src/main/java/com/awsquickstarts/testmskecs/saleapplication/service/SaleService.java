package com.awsquickstarts.testmskecs.saleapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.awsquickstarts.testmskecs.common.exception.BusinessException;
import com.awsquickstarts.testmskecs.saleapplication.to.SaleTo;

@Service
public class SaleService {

    private List<SaleTo> sales = new ArrayList<>();

    @Autowired
    private KafkaTemplate<String, SaleTo> kafkaTemplate;

    public List<SaleTo> findAll() {
        return this.sales;
    }

    public SaleTo save(final SaleTo sale) {

        System.out.println("Saving sale");

        if (!StringUtils.hasText(sale.getSaleShopId())) {
            throw new BusinessException("sale_shop_id is required");
        } else if (!StringUtils.hasText(sale.getSaleCustomerId())) {
            throw new BusinessException("sale_customer_id is required");
        } else if (sale.getSaleValue() == null) {
            throw new BusinessException("sale_value is required");
        } else if (sale.getSaleDate() == null) {
            throw new BusinessException("sale_date is required");
        }

        sale.setSaleId(String.valueOf(new Random().nextInt()));

        this.sales.add(sale);

        System.out.println("Sale has saved");

        publishSaleHasCompleted(sale);

        return sale;

    }

    private void publishSaleHasCompleted(final SaleTo sale) {

        System.out.println("Publishing the event 'sale has completed'");

        kafkaTemplate.send("sale_has_completed", sale);

        System.out.println("Event 'sale has completed' has published");

    }

}
