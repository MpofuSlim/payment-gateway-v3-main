package com.example.meraki.repositories;

import com.example.meraki.entities.Customers;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends BaseRepository<Customers>{

    Customers findByEmailAndPassword(String email, String password);
}
