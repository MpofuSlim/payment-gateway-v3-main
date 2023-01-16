package com.example.meraki.repositories;

import com.example.meraki.entities.CustomerPayment;
import com.example.meraki.entities.Customers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerPaymentRepository extends BaseRepository<CustomerPayment>{
    CustomerPayment getReferenceById(long id);

    List<CustomerPayment> findByCustomer(Customers customers);
}