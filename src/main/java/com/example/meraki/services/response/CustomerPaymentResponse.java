package com.example.meraki.services.response;


import com.example.meraki.entities.CustomerPayment;
import com.example.meraki.entities.Customers;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerPaymentResponse {

    private CustomerPayment customerPayment;

    private Customers customer;
}
