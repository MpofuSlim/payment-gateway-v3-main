package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.UserDTO.UserDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @ApiModel(description = "Create user payload")
    public class CreateUserRequestDTO {

        private UserDTO user;
    }
