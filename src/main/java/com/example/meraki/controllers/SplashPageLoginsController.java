package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateSplashPageLoginsRequestDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.controllers.splashPageLoginsDTO.SplashPageLoginsDTO;
import com.example.meraki.controllers.splashPageLoginsDTO.SplashPageLoginsDetailDTO;
import com.example.meraki.entities.Batch;
import com.example.meraki.entities.SplashPageLogins;
import com.example.meraki.services.CustomersService;
import com.example.meraki.services.SplashPageLoginsService;
import com.example.meraki.services.response.CreateSplashPageLoginsResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class SplashPageLoginsController {
    @Autowired
    private SplashPageLoginsService splashPageLoginsService;

    @Autowired
    private CustomersService customersService;


    @CrossOrigin
    @GetMapping(path = "/splash_page_logins/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all splash_page_logins", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<SplashPageLogins>> listAllSplashPageLogins(
    ) {
        List<SplashPageLogins> splashPageLogins;

        splashPageLogins = splashPageLoginsService.getAllSplashPageLogins();

        return new Response<>(ResponseCode.SUCCESS, "OK", splashPageLogins);
    }

    @CrossOrigin
    @GetMapping(path = "/splash_page_logins/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve splash_page_logins by id.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<SplashPageLogins>> getSplashPageLoginsById(
            @ApiParam(value = "id", example = "", required = true)
            @PathVariable Long id) {

        List<SplashPageLogins> splashPageLoginsList = splashPageLoginsService.getSplashPageLoginsById(id);

        return new Response<>(ResponseCode.SUCCESS, "OK", splashPageLoginsList);

    }


    @CrossOrigin
    @PostMapping(path = "/splash_page_logins/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "create splash logins", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<SplashPageLoginsDetailDTO> CreateSplashPageLogins(@RequestBody CreateSplashPageLoginsRequestDTO createSplashPageLoginsRequestDTO){

        SplashPageLoginsDetailDTO splashPageLoginsDetailDTO=null;
        try{
            CreateSplashPageLoginsResponse createSplashPageLoginsResponse = splashPageLoginsService.CreateSplashPageLogins(createSplashPageLoginsRequestDTO);
            splashPageLoginsDetailDTO=new SplashPageLoginsDetailDTO(
                    SplashPageLoginsDTO.fromSplashPageLogins(createSplashPageLoginsRequestDTO.getSplashPageLogins()),
                    CustomersDTO.fromCustomer(customersService.getCustomer(createSplashPageLoginsRequestDTO.getCustomerID()))

            );

        }catch (IOException e){

        }
        return new Response<>(ResponseCode.SUCCESS, "splashPageLogins  added.", splashPageLoginsDetailDTO);
    }
}
