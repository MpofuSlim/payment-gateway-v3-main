package com.example.meraki.repositories;

import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.AdminPortalUsersRoles;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AdminPortalUsersRolesRepository extends BaseRepository<AdminPortalUsersRoles>{
}
