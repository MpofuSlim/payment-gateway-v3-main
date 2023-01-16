package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateAdminPortalUsersRolesRequestDTO;
import com.example.meraki.common.updaterequests.UpdateAdminPortalUsersRequestDTO;
import com.example.meraki.common.updaterequests.UpdateAdminPortalUsersRolesRequestDTO;
import com.example.meraki.controllers.AdminPortalUsersRolesDTO.AdminPortalUsersRolesDTO;
import com.example.meraki.controllers.AdminPortalUsersRolesDTO.AdminPortalUsersRolesDetailDTO;
import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.entities.AdminPortalUsersRoles;
import com.example.meraki.services.AdminPortalUsersRolesService;
import com.example.meraki.services.UserService;
import com.example.meraki.services.response.CreateAdminPortalUsersRolesResponse;
import com.example.meraki.services.response.UpdateAdminPortalUsersResponse;
import com.example.meraki.services.response.UpdateAdminPortalUsersRolesResponse;
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
public class AdminPortalUsersRolesController {
    @Autowired
    private AdminPortalUsersRolesService adminPortalUsersRolesService;


    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping(path = "/admin-portal-user-role/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all admin-portal-users-roles?=true/false", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<AdminPortalUsersRoles>> listAdminPortalUsers(
    ) {
        List<AdminPortalUsersRoles> adminPortalUsersRoles;

        adminPortalUsersRoles = adminPortalUsersRolesService.getAllAdminPortalUsersRoles();

        return new Response<>(ResponseCode.SUCCESS, "OK", adminPortalUsersRoles);
    }

    @CrossOrigin
    @PutMapping("/admin-portal-user-role/{id}")
    @ApiParam(value = "update  adminPortalUsersRole", example = "", required = true)
    public Response<UpdateAdminPortalUsersRolesResponse> updateAdminPortalUsersRoles(
            @RequestBody UpdateAdminPortalUsersRolesRequestDTO updateAdminPortalUsersRolesRequestDTO) {
        UpdateAdminPortalUsersRolesResponse response =  adminPortalUsersRolesService.updateAdminPortalUsersRoles(updateAdminPortalUsersRolesRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }

    @CrossOrigin
    @PostMapping(path = "/admin-portal-user-role/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "all admin-portal-users-roles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<AdminPortalUsersRolesDetailDTO> CreateAdminPortalUserRoles(@RequestBody CreateAdminPortalUsersRolesRequestDTO createAdminPortalUsersRolesRequestDTO){

        AdminPortalUsersRolesDetailDTO adminPortalUsersRolesDetailDTO=null;
        try{
            CreateAdminPortalUsersRolesResponse createAdminPortalUsersRolesResponse = adminPortalUsersRolesService.createAdminPortalUsersRoles(createAdminPortalUsersRolesRequestDTO);
            adminPortalUsersRolesDetailDTO=new AdminPortalUsersRolesDetailDTO (
                    AdminPortalUsersRolesDTO.fromAdminPortalUsersRoles(createAdminPortalUsersRolesResponse.getAdminPortalUsersRoles())
                   // UserDTO.fromUser(userService.getUser(createAdminPortalUsersRolesRequestDTO.getUserID()))
            );

        }catch (IOException e){

        }
        return new Response<>(ResponseCode.SUCCESS, "admin-user-portal-role was added.", adminPortalUsersRolesDetailDTO);
    }


}
