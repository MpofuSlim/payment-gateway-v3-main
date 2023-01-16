package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateUserRequestDTO;
import com.example.meraki.common.misc.UserLoginRequestDTO;
import com.example.meraki.entities.Role;
import com.example.meraki.entities.User;
import com.example.meraki.services.UserService;
import com.example.meraki.services.response.CreateUserResponse;
import com.example.meraki.services.response.UserLoginResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;


    @CrossOrigin
    @GetMapping(path = "/user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<User>> listAllUser(
    ) {
        List<User> user;

        user = userService.getAllUsers();

        return new Response<>(ResponseCode.SUCCESS, "OK", user);
    }

    @CrossOrigin
    @PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create User", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CreateUserResponse> createUser(
            @ApiParam(required = true) @RequestBody CreateUserRequestDTO createUserRequestDTO) {

        CreateUserResponse createUserResponse=userService.CreateUser(createUserRequestDTO);

        return new Response<>(ResponseCode.SUCCESS, "Ok", createUserResponse);

    }



    @CrossOrigin
    @PostMapping(path = "/user/login/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Verify user", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<UserLoginResponse> listUsers(
            @ApiParam(value = "login user")
            @RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        UserLoginResponse userLoginResponse;

        if (userService.checkUserExists(userLoginRequestDTO)) {
            userLoginResponse = userService.loginResponse(userLoginRequestDTO);
            return new Response<>(ResponseCode.SUCCESS,
                    "OK", userLoginResponse
            );
        } else {
            return new Response<>(ResponseCode.NOT_FOUND,
                    "Incorrect username or password", null
            );
        }
    }
}

