package com.example.meraki.controllers.AdminPortalUsersRolesDTO;

import com.example.meraki.entities.AdminPortalUsersRoles;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "AdminPortalUsersRoles")
public class AdminPortalUsersRolesDTO {

    @ApiModelProperty(value ="voucher batchID", required = true, example = "")
    private String name;

    @ApiModelProperty(value ="voucher batchName", required = true, example = "")
    private Date date_created;

    public static AdminPortalUsersRolesDTO fromAdminPortalUsersRoles(AdminPortalUsersRoles adminPortalUsersRoles){
        return new AdminPortalUsersRolesDTO (adminPortalUsersRoles.getName(), adminPortalUsersRoles.getDate_created());
    }
}

