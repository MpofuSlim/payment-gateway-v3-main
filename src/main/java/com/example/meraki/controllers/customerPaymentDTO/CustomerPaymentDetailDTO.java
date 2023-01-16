package com.example.meraki.controllers.customerPaymentDTO;

import com.example.meraki.controllers.customerDTO.CustomersDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "customer payload")
public class CustomerPaymentDetailDTO {

    private CustomerPaymentDTO customerPayment;

    private CustomersDTO customers;

}
