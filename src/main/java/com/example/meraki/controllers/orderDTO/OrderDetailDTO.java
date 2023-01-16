package com.example.meraki.controllers.orderDTO;

import com.example.meraki.controllers.AdminPortalUsersDTO.AdminPortalUsersDTO;
import com.example.meraki.controllers.businessPartnerDTO.BusinessPartnerDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Order detailed info")

public class OrderDetailDTO {

    private OrderDTO order;

    private BusinessPartnerDTO businessPartner;

    private AdminPortalUsersDTO adminPortalUsers;


}
