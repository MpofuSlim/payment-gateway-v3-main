package com.example.meraki.common.misc;

import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.entities.Customers;
import com.example.meraki.entities.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create customer login payload")
public class CustomerLoginRequestDTO {

    @ApiModelProperty(example = "bctechy@live.com")
    private String email;

    @ApiModelProperty(example = "test")
    private String password;

    //@ApiModelProperty(example = "customer")
    //private CustomersDTO customers;
}
