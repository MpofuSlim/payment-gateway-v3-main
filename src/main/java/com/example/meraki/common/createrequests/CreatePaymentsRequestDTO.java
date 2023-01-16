package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.organisationDTO.OrganisationDTO;
import com.example.meraki.controllers.paymentsDTO.PaymentsDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Payments payload")
public class CreatePaymentsRequestDTO {

    private PaymentsDTO payments;

    private Long customerID;
}
