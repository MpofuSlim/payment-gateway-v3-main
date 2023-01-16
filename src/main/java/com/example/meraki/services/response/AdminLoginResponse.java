package com.example.meraki.services.response;

import com.example.meraki.entities.Role;
import io.swagger.annotations.ApiModel;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create admin login payload")
public class AdminLoginResponse {

    private String firstname;
    private String surname;
    private String email;
    private Role role;

}