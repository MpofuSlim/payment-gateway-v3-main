package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.AdminPortalUsersDTO.AdminPortalUsersDTO;
import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "create-admin-portal-users payload")
public class CreateAdminPortalUsersRequestDTO {

    private AdminPortalUsersDTO adminPortalUsersDTO;

   // private Long userID;

    private Long roleID;

}
