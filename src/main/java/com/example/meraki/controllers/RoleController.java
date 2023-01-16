package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateRoleRequestDTO;
import com.example.meraki.common.updaterequests.UpdateRoleRequestDTO;
import com.example.meraki.entities.Payments;
import com.example.meraki.entities.Role;
import com.example.meraki.services.RoleService;
import com.example.meraki.services.response.CreateRoleResponse;
import com.example.meraki.services.response.UpdateRoleResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RoleController {
    @Autowired
    private RoleService roleService;

    @CrossOrigin
    @GetMapping(path = "/role/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Role>> listAllPayments(
    ) {
        List<Role> roles;

        roles = roleService.getAllRoles();

        return new Response<>(ResponseCode.SUCCESS, "OK", roles);
    }

    @CrossOrigin
    @PutMapping("/Role/{id}")
    @ApiParam(value = "update role", example = "", required = true)
    public Response<UpdateRoleResponse> updateRole(
            @RequestBody UpdateRoleRequestDTO updateRoleRequestDTO) {
        UpdateRoleResponse response =  roleService.updateRole(updateRoleRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }


    @CrossOrigin
    @PostMapping(path = "/role/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create role ", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CreateRoleResponse> createRole(
            @ApiParam(required = true) @RequestBody CreateRoleRequestDTO createRoleRequestDTO) {

        CreateRoleResponse createRoleResponse=roleService.CreateRole(createRoleRequestDTO);

        return new Response<>(ResponseCode.SUCCESS, "Ok", createRoleResponse);

    }
}
