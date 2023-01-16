package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateCustomerRequestDTO;
import com.example.meraki.common.createrequests.CreateVoucherRequestDTO;
import com.example.meraki.common.misc.CustomerLoginRequestDTO;
import com.example.meraki.common.misc.UserLoginRequestDTO;
import com.example.meraki.common.updaterequests.UpdateCustomersRequestDTO;
import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.customerDTO.CustomerDetailDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.controllers.vouchersDTO.VoucherDetailDTO;
import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import com.example.meraki.entities.Currency;
import com.example.meraki.entities.Customers;
import com.example.meraki.services.BatchService;
import com.example.meraki.services.CustomersService;
import com.example.meraki.services.UserService;
import com.example.meraki.services.VouchersService;
import com.example.meraki.services.response.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class CustomersController {
    @Autowired
    private CustomersService customerService;


    @CrossOrigin
    @GetMapping(path = "/customer/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all customers?=true/false", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<Customers>> listCustomers(   ) {
        List<Customers> customers;

        customers = customerService.getAllCustomers();

        return new Response<>(ResponseCode.SUCCESS, "OK", customers);
    }

    @CrossOrigin
    @PutMapping("/customers/{id}")
    @ApiParam(value = "update  customers", example = "", required = true)
    public Response<UpdateCustomersResponse> updateCustomers(
            @RequestBody UpdateCustomersRequestDTO updateCustomersRequestDTO) {
        UpdateCustomersResponse response =  customerService.updateCustomers(updateCustomersRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }


    @CrossOrigin
    @PostMapping(path = "/customer/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "all customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<CustomerDetailDTO> CreateVoucherBatch(@RequestBody CreateCustomerRequestDTO createCustomerRequestDTO){

        CustomerDetailDTO customerDetailDTO=null;
        try{
            CreateCustomerResponse createCustomerResponse = customerService.createCustomer(createCustomerRequestDTO);
            customerDetailDTO=new CustomerDetailDTO(
                    CustomersDTO.fromCustomer(createCustomerResponse.getCustomers())
            );

        }catch (IOException e){

        }
        return new Response<>(ResponseCode.SUCCESS, "customer was added.", customerDetailDTO);
    }

    @CrossOrigin
    @PostMapping(path = "/customer/login/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Verify customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CustomerLoginResponse> listUsers(
            @ApiParam(value = "login customer")
            @RequestBody CustomerLoginRequestDTO customerLoginRequestDTO) {
        CustomerLoginResponse customerLoginResponse;

        if (customerService.checkUserExists(customerLoginRequestDTO)) {
            customerLoginResponse =customerService.loginResponse(customerLoginRequestDTO);
            return new Response<>(ResponseCode.SUCCESS,
                    "OK", customerLoginResponse
            );
        } else {
            return new Response<>(ResponseCode.NOT_FOUND,
                    "Incorrect username or password", null
            );
        }
    }
}
