package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateAdminPortalUsersRequestDTO;
import com.example.meraki.common.createrequests.CreateCustomerRequestDTO;
import com.example.meraki.common.misc.AdminLoginRequestDTO;
import com.example.meraki.common.misc.UserLoginRequestDTO;
import com.example.meraki.common.updaterequests.UpdateAdminPortalUsersRequestDTO;
import com.example.meraki.controllers.AdminPortalUsersDTO.AdminPortalUsersDTO;
import com.example.meraki.controllers.AdminPortalUsersDTO.AdminPortalUsersDetailDTO;
import com.example.meraki.controllers.RoleDTO.RoleDTO;
import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.customerDTO.CustomerDetailDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.services.*;
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
public class AdminPortalUsersController {
    @Autowired
    private AdminPortalUsersService adminPortalUsersService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping(path = "/admin-portal-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all admin-portal-users?=true/false", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<AdminPortalUsers>> listAdminPortalUsers(
    ) {
        List<AdminPortalUsers> adminPortalUsers;

        adminPortalUsers = adminPortalUsersService.getAllAdminPortalUsers();

        return new Response<>(ResponseCode.SUCCESS, "OK", adminPortalUsers);
    }

    @CrossOrigin
    @PutMapping("/adminPortalUsers/{id}")
    @ApiParam(value = "update  adminPortalUsers", example = "", required = true)
    public Response<UpdateAdminPortalUsersResponse> updateAdminPortalUsers(
            @RequestBody UpdateAdminPortalUsersRequestDTO updateAdminPortalUsersRequestDTO) {
        UpdateAdminPortalUsersResponse response =  adminPortalUsersService.updateAdminPortalUsers(updateAdminPortalUsersRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }


    @CrossOrigin
    @PostMapping(path = "/admin-portal-user/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "all admin-portal-users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<AdminPortalUsersDetailDTO> CreateAdminPortalUser(@RequestBody CreateAdminPortalUsersRequestDTO createAdminPortalUsersRequestDTO){

        AdminPortalUsersDetailDTO adminPortalUsersDetailDTO=null;
        try{
            CreateAdminPortalUsersResponse createAdminPortalUsersResponse = adminPortalUsersService.createAdminPortalUsers(createAdminPortalUsersRequestDTO);
            adminPortalUsersDetailDTO=new AdminPortalUsersDetailDTO (
                    AdminPortalUsersDTO.fromAdminPortalUsers(createAdminPortalUsersResponse.getAdminPortalUsers()),

                    RoleDTO.fromRole(roleService.getRole(createAdminPortalUsersRequestDTO.getRoleID()))
            );

        }catch (IOException e){

        }
        return new Response<>(ResponseCode.SUCCESS, "admin portal user added!!.", adminPortalUsersDetailDTO);
    }


    @CrossOrigin
    @PostMapping(path = "/admin-portal-user/login/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Verify admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<AdminLoginResponse> listUsers(
            @ApiParam(value = "login admin")
            @RequestBody AdminLoginRequestDTO adminLoginRequestDTO) {
        AdminLoginResponse adminLoginResponse;

        if (adminPortalUsersService.checkAdminExists(adminLoginRequestDTO)) {
            adminLoginResponse = adminPortalUsersService.loginResponse(adminLoginRequestDTO);
            return new Response<>(ResponseCode.SUCCESS,
                    "OK", adminLoginResponse
            );
        } else {
            return new Response<>(ResponseCode.NOT_FOUND,
                    "Incorrect username or password", null
            );
        }
    }
}
