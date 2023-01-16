package com.example.meraki.repositories;


import com.example.meraki.entities.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends BaseRepository<User>{

    User findByEmailAndPassword(String email, String password);

}


