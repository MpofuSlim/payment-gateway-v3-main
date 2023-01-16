package com.example.meraki.services;


import com.example.meraki.Config.gateway.PaymentGatewayRequest;
import com.example.meraki.Config.gateway.PaymentGatewayService;
import com.example.meraki.Config.gateway.PaymentResponse;
import com.example.meraki.common.createrequests.CreateCustomerPaymentRequestDTO;
import com.example.meraki.entities.CustomerPayment;
import com.example.meraki.entities.Customers;
import com.example.meraki.repositories.CustomerPaymentRepository;
import com.example.meraki.repositories.CustomersRepository;
import com.example.meraki.services.response.CreateCustomerPaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class CustomerPaymentService {
    @Autowired
    private PaymentGatewayService paymentGatewayService;

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    public CustomerPaymentRepository customerPaymentRepository;

    public List<CustomerPayment> getAllCustomerPayments() {
        return customerPaymentRepository.findAll();
    }

    public List<CustomerPayment> getByCustomerId(Customers customer) {
        return customerPaymentRepository.findByCustomer(customer);
    }

    public CustomerPaymentService(CustomerPaymentRepository customerPaymentRepository, CustomersRepository customersRepository) {
        this.customerPaymentRepository = customerPaymentRepository;
        this.customersRepository = customersRepository;
    }


    public boolean checkCustomerIdExistsInCustomer(Long id, CustomersService customersService) {
        boolean result = false;

        try {

            customerPaymentRepository.findByCustomer(customersService.getCustomer(id));
        } catch (EntityNotFoundException entityNotFoundException) {
            result = true;
        }
        return result;
    }

    public CreateCustomerPaymentResponse initiateMobileMoneyPayment(CreateCustomerPaymentRequestDTO createCustomerPaymentRequestDTO) throws IOException {
        Customers customer1 = customersRepository.getReferenceById(createCustomerPaymentRequestDTO.getCustomerID());

        log.info("Starting payment");

        CustomerPayment customerPayment1 = new CustomerPayment(
                customer1,
                createCustomerPaymentRequestDTO.getCustomerPayment().getAmount(),
                createCustomerPaymentRequestDTO.getCustomerPayment().getPhoneNumber(),
                createCustomerPaymentRequestDTO.getCustomerPayment().getProductId(),
                createCustomerPaymentRequestDTO.getCustomerPayment().getEmail(),
                createCustomerPaymentRequestDTO.getCustomerPayment().getProductTitle()
        );

        final PaymentGatewayRequest paymentRequest = PaymentGatewayRequest.builder()
                .amount(createCustomerPaymentRequestDTO.getCustomerPayment().getAmount())
                .msisdn(createCustomerPaymentRequestDTO.getCustomerPayment().getPhoneNumber())
                .currencyCode("ZWL")
                .reference(createCustomerPaymentRequestDTO.getCustomerPayment().getEmail()) //email
                .remarks(createCustomerPaymentRequestDTO.getCustomerPayment().getProductTitle()) //product title
                .reference(UUID.randomUUID().toString())
                .build();

        final PaymentResponse initiate = paymentGatewayService.initiate(paymentRequest);

        //Check if the request was successful

        customerPaymentRepository.save(customerPayment1);
            return new CreateCustomerPaymentResponse(
                    customerPayment1,
                    customer1
            );

        }
}

