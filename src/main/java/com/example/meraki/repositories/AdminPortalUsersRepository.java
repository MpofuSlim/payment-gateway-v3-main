package com.example.meraki.repositories;


import com.example.meraki.entities.AdminPortalUsers;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminPortalUsersRepository extends BaseRepository<AdminPortalUsers> {

    AdminPortalUsers findByEmailAddressAndPassword(String email_address, String password);
}
