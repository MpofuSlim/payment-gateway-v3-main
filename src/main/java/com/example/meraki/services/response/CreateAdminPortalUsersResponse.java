package com.example.meraki.services.response;

import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.Customers;
import com.example.meraki.entities.Role;
import com.example.meraki.entities.User;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "CreateAdminPortalUsers payload")
public class CreateAdminPortalUsersResponse {

    private AdminPortalUsers adminPortalUsers;

    //private User user;

    private Role role;
}
