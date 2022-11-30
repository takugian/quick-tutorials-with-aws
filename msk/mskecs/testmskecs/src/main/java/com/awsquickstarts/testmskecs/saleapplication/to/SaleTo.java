package com.awsquickstarts.testmskecs.saleapplication.to;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "saleId" })
@ToString
public class SaleTo {

    @JsonProperty(value = "sale_id")
    private String saleId;

    @JsonProperty(value = "sale_shop_id")
    private String saleShopId;

    @JsonProperty(value = "sale_customer_id")
    private String saleCustomerId;

    @JsonProperty(value = "sale_value")
    private BigDecimal saleValue;

    @JsonProperty(value = "sale_date")
    private LocalDate saleDate;

}
