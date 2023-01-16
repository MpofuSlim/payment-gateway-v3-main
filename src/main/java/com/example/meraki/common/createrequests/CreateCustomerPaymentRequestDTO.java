package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.controllers.customerPaymentDTO.CustomerPaymentDTO;
import com.example.meraki.entities.Customers;
import com.example.meraki.services.CustomerPaymentService;
import io.swagger.annotations.ApiModel;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create payment payload")
public class CreateCustomerPaymentRequestDTO {

    private CustomerPaymentDTO customerPayment;

    private Long customerID;

}
