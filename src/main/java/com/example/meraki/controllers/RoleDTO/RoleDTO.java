package com.example.meraki.controllers.RoleDTO;


import com.example.meraki.entities.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "role")
public class RoleDTO {

    @ApiModelProperty(value = "description of the role of the user. Required", required = true)
    private String role;

    public static  RoleDTO fromRole(Role role){
        return new RoleDTO(role.getRole());
    }
}


