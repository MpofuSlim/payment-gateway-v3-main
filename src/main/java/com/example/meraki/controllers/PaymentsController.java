package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateCustomerRequestDTO;
import com.example.meraki.common.createrequests.CreatePaymentsRequestDTO;
import com.example.meraki.common.updaterequests.UpdatePaymentsRequestDTO;
import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.customerDTO.CustomerDetailDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.controllers.paymentsDTO.PaymentsDTO;
import com.example.meraki.controllers.paymentsDTO.PaymentsDetailDTO;
import com.example.meraki.entities.Networks;
import com.example.meraki.entities.Payments;
import com.example.meraki.services.CustomersService;
import com.example.meraki.services.PaymentsService;
import com.example.meraki.services.UserService;
import com.example.meraki.services.VouchersService;
import com.example.meraki.services.response.CreateCustomerResponse;
import com.example.meraki.services.response.CreatePaymentsResponse;
import com.example.meraki.services.response.UpdatePaymentsResponse;
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
public class PaymentsController {
    @Autowired
    private PaymentsService paymentsService;


    @Autowired
    private CustomersService customersService;

    @CrossOrigin
    @GetMapping(path = "/payments/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all payments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Payments>> listAllPayments(
    ) {
        List<Payments> payments;

        payments = paymentsService.getAllPayments();

        return new Response<>(ResponseCode.SUCCESS, "OK", payments);
    }

    @CrossOrigin
    @PutMapping("/payments/{id}")
    @ApiParam(value = "update payments", example = "", required = true)
    public Response<UpdatePaymentsResponse> updatePayments(
            @RequestBody UpdatePaymentsRequestDTO updatePaymentsRequestDTO) {
        UpdatePaymentsResponse response =  paymentsService.updatePayments(updatePaymentsRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }


    @CrossOrigin
    @PostMapping(path = "/payments/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "all payments", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<PaymentsDetailDTO> CreateVoucherBatch(@RequestBody CreatePaymentsRequestDTO createPaymentsRequestDTO){

        PaymentsDetailDTO paymentsDetailDTO=null;
        try{
            CreatePaymentsResponse createPaymentsResponse = paymentsService.createPayments(createPaymentsRequestDTO);
            paymentsDetailDTO=new PaymentsDetailDTO(
                    PaymentsDTO.fromPayments(createPaymentsResponse.getPayments()),
                    CustomersDTO.fromCustomer(customersService.getCustomer(createPaymentsRequestDTO.getCustomerID()))
            );

        }catch (IOException e){

        }
        return new Response<>(ResponseCode.SUCCESS, "payment  added.", paymentsDetailDTO);
    }
}
