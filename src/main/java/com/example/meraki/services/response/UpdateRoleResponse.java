package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateRoleResponse {

    @ApiModelProperty(value = "role", example = "")
    private  String role;

    @ApiModelProperty(value = "role status", example = "")
    private Boolean active;
}
