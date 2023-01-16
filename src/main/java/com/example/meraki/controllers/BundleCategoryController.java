package com.example.meraki.controllers;


import com.example.meraki.common.createrequests.CreateBundleCategoryRequestDTO;
import com.example.meraki.common.createrequests.CreateCustomerRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBundleCategoryRequestDTO;
import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.bundlesDTO.BundleCategoryDTO;
import com.example.meraki.controllers.bundlesDTO.BundleCategoryDetailDTO;
import com.example.meraki.controllers.customerDTO.CustomerDetailDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.entities.AdminPortalUsersRoles;
import com.example.meraki.entities.BundleCategory;
import com.example.meraki.services.BundleCategoryService;
import com.example.meraki.services.CustomersService;
import com.example.meraki.services.UserService;
import com.example.meraki.services.VouchersService;
import com.example.meraki.services.response.CreateBundleCategoryResponse;
import com.example.meraki.services.response.CreateCustomerResponse;
import com.example.meraki.services.response.UpdateBundleCategoryResponse;
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
public class BundleCategoryController {
    @Autowired
    private BundleCategoryService bundleCategoryService;

    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping(path = "/bundle-category/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all bundle-category?=true/false", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<BundleCategory>> listBundleCategory(
    ) {
        List<BundleCategory> bundleCategory;

        bundleCategory =  bundleCategoryService.getAllBundleCategory();

        return new Response<>(ResponseCode.SUCCESS, "OK",  bundleCategory);
    }

    @CrossOrigin
    @PutMapping("/bundleCategory/{id}")
    @ApiParam(value = "update  bundleCategory", example = "", required = true)
    public Response<UpdateBundleCategoryResponse> updateBundleCategory(
            @RequestBody UpdateBundleCategoryRequestDTO updateBundleCategoryRequestDTO) {
        UpdateBundleCategoryResponse response =  bundleCategoryService.updateBundleCategory(updateBundleCategoryRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }

    @CrossOrigin
    @PostMapping(path = "/bundleCategory/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "all bundleCategories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<BundleCategoryDetailDTO> CreateVoucherBatch(@RequestBody CreateBundleCategoryRequestDTO createBundleCategoryRequestDTO){

        BundleCategoryDetailDTO bundleCategoryDetailDTO=null;
        try{
            CreateBundleCategoryResponse createBundleCategoryResponse = bundleCategoryService.createBundleCategory(createBundleCategoryRequestDTO);
            bundleCategoryDetailDTO=new  BundleCategoryDetailDTO(
                    BundleCategoryDTO.fromBundleCategory(createBundleCategoryResponse.getBundleCategory()),
                    UserDTO.fromUser(userService.getUser(createBundleCategoryRequestDTO.getUserID()))
            );

        }catch (IOException e){

        }
        return new Response<>(ResponseCode.SUCCESS, "bundleCategory was added.",  bundleCategoryDetailDTO);
    }
}
