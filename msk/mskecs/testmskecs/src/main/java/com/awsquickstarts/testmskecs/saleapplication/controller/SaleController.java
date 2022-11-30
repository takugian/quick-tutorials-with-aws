package com.awsquickstarts.testmskecs.saleapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsquickstarts.testmskecs.common.exception.BusinessException;
import com.awsquickstarts.testmskecs.common.to.ErrorTo;
import com.awsquickstarts.testmskecs.saleapplication.service.SaleService;
import com.awsquickstarts.testmskecs.saleapplication.to.SaleTo;

@RestController
@RequestMapping(path = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<Object> getSales() {

        try {

            final List<SaleTo> sales = this.saleService.findAll();

            return new ResponseEntity<Object>(sales, null, HttpStatusCode.valueOf(200));

        } catch (BusinessException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(400));
        } catch (Exception e) {
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(500));
        }

    }

    @PostMapping
    public ResponseEntity<Object> postSales(@RequestBody final SaleTo sale) {

        try {

            final SaleTo saleSaved = this.saleService.save(sale);

            return new ResponseEntity<Object>(saleSaved, HttpStatusCode.valueOf(200));

        } catch (BusinessException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(400));
        } catch (Exception e) {
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(500));
        }

    }

}
