package com.example.meraki.common.misc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create customer login payload")
public class AdminLoginRequestDTO {

    @ApiModelProperty(example = "bctechy@live.com")
    private String emailAddress;

    @ApiModelProperty(example = "test")
    private String password;
}