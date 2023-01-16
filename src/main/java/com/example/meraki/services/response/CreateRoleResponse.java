package com.example.meraki.services.response;

import com.example.meraki.entities.Role;
import com.example.meraki.entities.User;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "role payload")
public class CreateRoleResponse {

    private Role role;
}
