package com.example.meraki.services.response;

import com.example.meraki.entities.CustomerPayment;
import com.example.meraki.entities.Customers;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateCustomerPaymentResponse {

    private CustomerPayment customerPayment;

    private Customers customer;

}
