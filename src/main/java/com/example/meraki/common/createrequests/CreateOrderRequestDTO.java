package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.orderDTO.OrderDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "create order request payload")

public class CreateOrderRequestDTO {

    private OrderDTO order;

    private Long businessPartnerId;

    private Long adminPortalUserId;

}
