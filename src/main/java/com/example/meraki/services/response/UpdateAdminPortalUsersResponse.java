package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateAdminPortalUsersResponse {

    @ApiModelProperty(value = "firstName", example = "")
    private String firstname;

    @ApiModelProperty(value = "surname", example = "")
    private String surname;

    @ApiModelProperty(value = "email-address", example = "")
    private String email_address;

    @ApiModelProperty(value = "active state", example = "")
    private Boolean active;
}


