package com.example.meraki.controllers.salesDTO;

import com.example.meraki.controllers.bundlesDTO.BundlesDTO;
import com.example.meraki.controllers.orderDTO.OrderDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Sales detailed info")
public class SalesDetailDTO {

    private SalesDTO sales;

    private BundlesDTO bundlesDTO;

    private OrderDTO orderDTO;

}
