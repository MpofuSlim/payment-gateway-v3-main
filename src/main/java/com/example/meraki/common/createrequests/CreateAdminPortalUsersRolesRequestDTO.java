package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.AdminPortalUsersRolesDTO.AdminPortalUsersRolesDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create-admin-Portal-users-roles roles")
public class CreateAdminPortalUsersRolesRequestDTO {

    private AdminPortalUsersRolesDTO adminPortalUsersRolesDTO;

    private Long userID;

}
