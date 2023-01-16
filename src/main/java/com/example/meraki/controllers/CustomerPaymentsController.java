package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateCustomerPaymentRequestDTO;
import com.example.meraki.common.updaterequests.UpdateCustomersPaymentRequestDTO;
import com.example.meraki.common.updaterequests.UpdateVoucherRequestDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.controllers.customerPaymentDTO.CustomerPaymentDTO;
import com.example.meraki.controllers.customerPaymentDTO.CustomerPaymentDetailDTO;
import com.example.meraki.entities.CustomerPayment;
import com.example.meraki.entities.Customers;
import com.example.meraki.services.CustomerPaymentService;
import com.example.meraki.services.CustomersService;
import com.example.meraki.services.response.CreateCustomerPaymentResponse;
//import com.example.meraki.services.response.UpdateCustomersPaymentResponse;
import com.example.meraki.services.response.UpdateCustomersResponse;
import com.example.meraki.services.response.UpdateVoucherResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;


@RestController
public class CustomerPaymentsController {

    private CustomerPaymentService customerPaymentService;


    private CustomersService customerService;

    public CustomerPaymentsController(@Autowired CustomerPaymentService customerPaymentService, @Autowired CustomersService customerService) {
        this.customerPaymentService = customerPaymentService;
        this.customerService = customerService;
    }

    /*@CrossOrigin
    @PutMapping("/pay/{id}")
    @ApiParam(value = "update voucher", example = "", required = true)
    public Response<UpdateCustomersPaymentResponse> updatePaymentStatus(
            @RequestBody UpdateCustomersPaymentRequestDTO updateCustomersPaymentRequestDTO) {
        UpdateCustomersPaymentResponse response = customerPaymentService.updateCustomerPayment(updateCustomersPaymentRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }*/

    @CrossOrigin
    @GetMapping(path = "/pay/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve all customer payments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<CustomerPayment>> listPayments(
    ) {
        List<CustomerPayment> payments;

        payments = customerPaymentService.getAllCustomerPayments();

        return new Response<>(ResponseCode.SUCCESS, "OK", payments);
    }

    @CrossOrigin
    @PostMapping(path = "/pay/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "payment update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CustomerPaymentDetailDTO> processPaynowUpdate(@RequestBody CreateCustomerPaymentRequestDTO createCustomerPaymentRequestDTO) {

        CustomerPaymentDetailDTO customerPaymentDetailDTO = null;
        try {
            CreateCustomerPaymentResponse createCustomerPaymentResponse = customerPaymentService.initiateMobileMoneyPayment(createCustomerPaymentRequestDTO);
            customerPaymentDetailDTO = new CustomerPaymentDetailDTO(
                    CustomerPaymentDTO.fromCustomerPayment(createCustomerPaymentResponse.getCustomerPayment()),
                    CustomersDTO.fromCustomer(customerService.getCustomer(createCustomerPaymentRequestDTO.getCustomerID()))
            );

        } catch (IOException e) {

        }
        return new Response<>(ResponseCode.SUCCESS, "payment added.", customerPaymentDetailDTO);

    }

    @CrossOrigin
    @GetMapping(path = "/pay/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve By customer Id", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<CustomerPaymentDetailDTO>> getCustomerById(
            @ApiParam(value = "Id of the customer", example = "1", required = true)
            @PathVariable Long customerId) {

        if (customerPaymentService.checkCustomerIdExistsInCustomer(customerId, this.customerService)) {

            return new Response<>(ResponseCode.NOT_FOUND, "No Id in this customer", null);
        } else {
            List<CustomerPayment> customerPaymentsResult = customerPaymentService.getByCustomerId(customerService.getCustomer(customerId));
            List<CustomerPaymentDetailDTO> payload = customerPaymentsResult.stream().map(this::getCustomerPaymentDetail).collect(toList());
            return new Response<>(ResponseCode.SUCCESS, "OK", payload);
        }
    }

    private CustomerPaymentDetailDTO getCustomerPaymentDetail(CustomerPayment customerPayment) {
        Customers customers = customerService.getCustomer(customerPayment.getCustomer().getId());

        return new CustomerPaymentDetailDTO(CustomerPaymentDTO.fromCustomerPayment(customerPayment),
                CustomersDTO.fromCustomer(customers)
        );

    }
}
