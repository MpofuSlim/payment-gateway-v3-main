package com.example.meraki.controllers.businessPartnerDTO;

import com.example.meraki.controllers.orderDTO.OrderDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Business Partner detailed info")

public class BusinessPartnerDetailDTO {

    private BusinessPartnerDTO businessPartner;

    private OrderDTO order;
}
