package com.awsquickstarts.testmskecs.deliveryapplication.to;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "deliveryId" })
@ToString
public class DeliveryTo {

    @JsonProperty(value = "delivery_id")
    private String deliveryId;

    @JsonProperty(value = "sale_id")
    private String saleId;

}
