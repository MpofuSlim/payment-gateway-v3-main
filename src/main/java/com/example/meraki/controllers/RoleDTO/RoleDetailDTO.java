package com.example.meraki.controllers.RoleDTO;

import com.example.meraki.entities.Role;
import io.swagger.annotations.ApiModelProperty;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleDetailDTO {

    private RoleDTO role;
}
