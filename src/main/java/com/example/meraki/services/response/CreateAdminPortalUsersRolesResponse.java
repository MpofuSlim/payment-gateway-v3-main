package com.example.meraki.services.response;

import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.AdminPortalUsersRoles;
import com.example.meraki.entities.Role;
import com.example.meraki.entities.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateAdminPortalUsersRolesResponse {

    private AdminPortalUsersRoles adminPortalUsersRoles;

    private User user;

}
