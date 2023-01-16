package com.example.meraki.common.misc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create user login payload")
public class UserLoginRequestDTO {

    @ApiModelProperty(example = "test@test.test")
    private String email;

    @ApiModelProperty(example = "test")
    private String password;
}