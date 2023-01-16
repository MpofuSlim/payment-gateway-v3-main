package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateRoleRequestDTO {

    @ApiModelProperty(value = "role id", example = "")
    private Long id;

    @ApiModelProperty(value = "role", example = "")
    private  String role;

    @ApiModelProperty(value = "role status", example = "")
    private Boolean active;
}
