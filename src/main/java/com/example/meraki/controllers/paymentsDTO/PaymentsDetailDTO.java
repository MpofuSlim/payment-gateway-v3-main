package com.example.meraki.controllers.paymentsDTO;

import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.controllers.networksDTO.NetworksDTO;
import com.example.meraki.controllers.organisationDTO.OrganisationDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "payments detailed info")
public class PaymentsDetailDTO {

    private PaymentsDTO payments;

    private CustomersDTO customers;

}
