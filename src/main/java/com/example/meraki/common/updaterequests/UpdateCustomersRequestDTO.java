package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateCustomersRequestDTO {

    @ApiModelProperty(value = "customer id", example = "")
    private Long id;

    @ApiModelProperty(value = "customer firstname", example = "")
    private String firstname;

    @ApiModelProperty(value = "customer surname", example = "")
    private String surname;

    @ApiModelProperty(value = "customer phone_number", example = "")
    private String phone_number;

    @ApiModelProperty(value = "customer email", example = "")
    private String email;

    @ApiModelProperty(value = "customer password", example = "")
    private String password;

}

