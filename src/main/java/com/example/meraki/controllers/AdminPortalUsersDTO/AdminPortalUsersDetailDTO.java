package com.example.meraki.controllers.AdminPortalUsersDTO;

import com.example.meraki.controllers.RoleDTO.RoleDTO;
import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "AdminPortalUsers detailed info")
public class AdminPortalUsersDetailDTO {

    private AdminPortalUsersDTO adminPortalUsers;

   // private UserDTO user;
    
    private RoleDTO role;
}
