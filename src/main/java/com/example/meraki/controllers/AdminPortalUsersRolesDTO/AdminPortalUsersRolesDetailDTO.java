package com.example.meraki.controllers.AdminPortalUsersRolesDTO;

import com.example.meraki.controllers.AdminPortalUsersDTO.AdminPortalUsersDTO;
import com.example.meraki.controllers.RoleDTO.RoleDTO;
import com.example.meraki.controllers.UserDTO.UserDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "AdminPortalUsersRoles Detail")
public class AdminPortalUsersRolesDetailDTO {

    private AdminPortalUsersRolesDTO adminPortalUsersRoles;

   // private UserDTO user;

}
