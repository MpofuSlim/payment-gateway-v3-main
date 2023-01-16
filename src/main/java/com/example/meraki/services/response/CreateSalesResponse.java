package com.example.meraki.services.response;


import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.Order;
import com.example.meraki.entities.Sales;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Update sales payload")

public class CreateSalesResponse {

    private Sales sales;

    private Order order;

    private Bundles bundles;

}

