package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreatePaymentsRequestDTO;
import com.example.meraki.common.createrequests.CreateSplashPageConnectionsRequestDTO;
import com.example.meraki.common.updaterequests.UpdateSplashPageConnectionsRequestDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.controllers.splashPageConnectionsDTO.SplashPageConnectionDetailDTO;
import com.example.meraki.controllers.splashPageConnectionsDTO.SplashPageConnectionsDTO;
import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import com.example.meraki.entities.Payments;
import com.example.meraki.entities.SplashPageConnections;
import com.example.meraki.services.CustomersService;
import com.example.meraki.services.PaymentsService;
import com.example.meraki.services.SplashPageConnectionsService;
import com.example.meraki.services.VouchersService;
import com.example.meraki.services.response.CreateSplashPageConnectionsResponse;
import com.example.meraki.services.response.UpdateSplashPageConnectionsResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class SplashPageConnectionsController {
    @Autowired
    private SplashPageConnectionsService splashPageConnectionsService;

    @Autowired
    private CustomersService customersService;

    @Autowired
    private VouchersService vouchersService;

    @CrossOrigin
    @GetMapping(path = "/splash_page_connections/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all splash_page_connections", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<SplashPageConnections>> listAllPayments(
    ) {
        List<SplashPageConnections> splashPageConnections;

        splashPageConnections = splashPageConnectionsService.getAllSplashPageConnections();

        return new Response<>(ResponseCode.SUCCESS, "OK", splashPageConnections);
    }


    @CrossOrigin
    @PutMapping("/splash_page_connections/{id}")
    @ApiParam(value = "update splash_page_connections", example = "", required = true)
    public Response<UpdateSplashPageConnectionsResponse> updateSplashPageConnections(
            @RequestBody UpdateSplashPageConnectionsRequestDTO updateSplashPageConnectionsRequestDTO) {
        UpdateSplashPageConnectionsResponse response =  splashPageConnectionsService.updateSplashPageConnections(updateSplashPageConnectionsRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }

    @CrossOrigin
    @PostMapping(path = "/splash_page_connections/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "all splash connections", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<SplashPageConnectionDetailDTO> CreateSplashPageConnections(@RequestBody CreateSplashPageConnectionsRequestDTO createSplashPageConnectionsRequestDTO){

        SplashPageConnectionDetailDTO splashPageConnectionDetailDTO=null;
        try{
            CreateSplashPageConnectionsResponse createSplashPageConnectionsResponse = splashPageConnectionsService.CreateSplashPageConnections(createSplashPageConnectionsRequestDTO);
            splashPageConnectionDetailDTO=new SplashPageConnectionDetailDTO(
                    SplashPageConnectionsDTO.fromSplashPageConnections(createSplashPageConnectionsRequestDTO.getSplashPageConnections()),
                    CustomersDTO.fromCustomer(customersService.getCustomer(createSplashPageConnectionsRequestDTO.getCustomerID())),
                    VouchersDTO.fromVoucher(vouchersService.getVoucher(createSplashPageConnectionsRequestDTO.getVoucherID()))
            );

        }catch (IOException e){

        }
        return new Response<>(ResponseCode.SUCCESS, "splashPageConnection  added.", splashPageConnectionDetailDTO);
    }
}
