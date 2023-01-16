package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateCustomerRequestDTO;
import com.example.meraki.common.misc.CustomerLoginRequestDTO;
import com.example.meraki.common.updaterequests.UpdateCustomersRequestDTO;
import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.Currency;
import com.example.meraki.entities.Customers;
import com.example.meraki.entities.User;
import com.example.meraki.repositories.CustomersRepository;
import com.example.meraki.repositories.UserRepository;
import com.example.meraki.services.response.CreateCustomerResponse;
import com.example.meraki.services.response.CustomerLoginResponse;
import com.example.meraki.services.response.UpdateCustomersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private UserRepository userRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public Customers getCustomer(Long id) {
        return customersRepository.getReferenceById(id);
    }

    public List<Customers> getAllCustomers(){
        return customersRepository.findAll();
    }
    public CreateCustomerResponse createCustomer(CreateCustomerRequestDTO createCustomerRequestDTO) throws IOException {

        Customers customers = new Customers(

                createCustomerRequestDTO.getCustomers().getFirstname(),
                createCustomerRequestDTO.getCustomers().getSurname(),
                createCustomerRequestDTO.getCustomers().getPhone_number(),
                createCustomerRequestDTO.getCustomers().getEmail(),
                createCustomerRequestDTO.getCustomers().getPassword()
        );

        customersRepository.save(customers);

        return new CreateCustomerResponse(
                customers

        );
    }

    public UpdateCustomersResponse updateCustomers(UpdateCustomersRequestDTO updateCustomersRequestDTO) {
        Customers customers = customersRepository.getReferenceById(updateCustomersRequestDTO.getId());
        customers.setFirstname(updateCustomersRequestDTO.getFirstname());
        customers.setSurname(updateCustomersRequestDTO.getSurname());
        customers.setPhone_number(updateCustomersRequestDTO.getPhone_number());
        customers.setEmail(updateCustomersRequestDTO.getEmail());
        customers.setPassword(updateCustomersRequestDTO.getPassword());


        customersRepository.save(customers);

        UpdateCustomersResponse updateCustomersResponse = new UpdateCustomersResponse(
                customers.getFirstname(),
                customers.getSurname(),
                customers.getPhone_number(),
                customers.getEmail(),
                customers.getPassword()
        );

        return  updateCustomersResponse;
    }


    public boolean checkUserExists(CustomerLoginRequestDTO customerLoginRequestDTO) {
        Customers customers = customersRepository.findByEmailAndPassword(customerLoginRequestDTO.getEmail(), customerLoginRequestDTO.getPassword());

        if (customers == null) {
            return false;
        } else {
            return true;
        }
    }


    public CustomerLoginResponse loginResponse(CustomerLoginRequestDTO customerLoginRequestDTO) {
        Customers customers = customersRepository.findByEmailAndPassword(customerLoginRequestDTO.getEmail(), customerLoginRequestDTO.getPassword());
        return new CustomerLoginResponse(
                customers.getId(),
                customers.getFirstname(),
                customers.getSurname()

        );
    }
}
