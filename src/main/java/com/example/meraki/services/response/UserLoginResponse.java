package com.example.meraki.services.response;


import io.swagger.annotations.ApiModel;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create user login payload")
public class UserLoginResponse {
    private String name;
    private String surname;

}
