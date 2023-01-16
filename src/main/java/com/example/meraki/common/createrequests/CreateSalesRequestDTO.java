package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.salesDTO.SalesDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "create sales request payload")

public class CreateSalesRequestDTO {

    private SalesDTO sales;

    private Long bundlesId;

    private Long orderId;




}
