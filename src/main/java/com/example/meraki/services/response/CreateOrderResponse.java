package com.example.meraki.services.response;

import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.BusinessPartner;
import com.example.meraki.entities.Order;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Update order payload")

public class CreateOrderResponse {


    private Order order;

    private BusinessPartner businessPartner;

    private AdminPortalUsers adminPortalUsers;
}
