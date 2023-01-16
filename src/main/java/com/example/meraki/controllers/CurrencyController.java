package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateCurrencyRequestDTO;
import com.example.meraki.common.createrequests.CreateCustomerRequestDTO;
import com.example.meraki.common.updaterequests.UpdateCurrencyRequestDTO;
import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.currencyDTO.CurrencyDTO;
import com.example.meraki.controllers.currencyDTO.CurrencyDetailDTO;
import com.example.meraki.controllers.customerDTO.CustomerDetailDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.Currency;
import com.example.meraki.services.CurrencyService;
import com.example.meraki.services.CustomersService;
import com.example.meraki.services.UserService;
import com.example.meraki.services.VouchersService;
import com.example.meraki.services.response.CreateCurrencyResponse;
import com.example.meraki.services.response.CreateCustomerResponse;
import com.example.meraki.services.response.UpdateCurrencyResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping(path = "/currency/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all currency?=true/false", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<Currency>> listCurrency(   ) {
        List<Currency> currency;

        currency = currencyService.getAllCurrency();

        return new Response<>(ResponseCode.SUCCESS, "OK", currency);
    }

    @CrossOrigin
    @PutMapping("/currency/{id}")
    @ApiParam(value = "update  currency", example = "", required = true)
    public Response<UpdateCurrencyResponse> updateCurrency(
            @RequestBody UpdateCurrencyRequestDTO updateCurrencyRequestDTO) {
        UpdateCurrencyResponse response =  currencyService.updateCurrency(updateCurrencyRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }

    @CrossOrigin
    @PostMapping(path = "/currency/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "all currency", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<CurrencyDetailDTO> CreateCurrency(@RequestBody CreateCurrencyRequestDTO createCurrencyRequestDTO){

        CurrencyDetailDTO currencyDetailDTO=null;
        try{
            CreateCurrencyResponse createCurrencyResponse = currencyService.createCurrency(createCurrencyRequestDTO);
            currencyDetailDTO=new CurrencyDetailDTO(
                    CurrencyDTO.fromCurrency(createCurrencyResponse.getCurrency()),
                    UserDTO.fromUser(userService.getUser(createCurrencyRequestDTO.getUserID()))
            );

        }catch (IOException e){

        }
        return new Response<>(ResponseCode.SUCCESS, "currency was added.", currencyDetailDTO);
    }
}
