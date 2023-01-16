package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateBasePriceRequestDTO;
import com.example.meraki.common.createrequests.CreateBusinessPartnerRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBasePriceRequestDTO;
import com.example.meraki.common.updaterequests.UpdateExchangeRateRequestDTO;
import com.example.meraki.entities.BasePrice;
import com.example.meraki.entities.BusinessPartner;
import com.example.meraki.services.BasePriceService;
import com.example.meraki.services.BusinessPartnerService;
import com.example.meraki.services.response.CreateBasePriceResponse;
import com.example.meraki.services.response.CreateBusinessPartnerResponse;
import com.example.meraki.services.response.UpdateBasePriceResponse;
import com.example.meraki.services.response.UpdateExchangeRateResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BasePriceController {
    @Autowired
    private BasePriceService basePriceService;


    @CrossOrigin
    @GetMapping(path = "/base_price/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all BasePrices", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<BasePrice>> listBasePrices(   ) {
        List<BasePrice> basePrice;

        basePrice = basePriceService.getAllBasePrice();

        return new Response<>(ResponseCode.SUCCESS, "OK", basePrice);
    }


    @CrossOrigin
    @PostMapping(path = "/base_price/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create base price ", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CreateBasePriceResponse> createBasePrice(
            @ApiParam(required = true) @RequestBody CreateBasePriceRequestDTO createBasePriceRequestDTO) {

        CreateBasePriceResponse createBasePriceResponse=basePriceService.CreateBasePrice(createBasePriceRequestDTO);

        return new Response<>(ResponseCode.SUCCESS, "Ok", createBasePriceResponse);

    }

    @CrossOrigin
    @PutMapping("/base_price/{id}")
    @ApiParam(value = "update  basePrice", example = "", required = true)
    public Response<UpdateBasePriceResponse> updateBasePrice(
            @RequestBody UpdateBasePriceRequestDTO updateBasePriceRequestDTO) {
        UpdateBasePriceResponse response =   basePriceService.updateBasePrice(updateBasePriceRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }
}
