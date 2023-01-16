package com.example.meraki.services;


import com.example.meraki.common.createrequests.CreateSplashPageLoginsRequestDTO;
import com.example.meraki.entities.Batch;
import com.example.meraki.entities.Customers;
import com.example.meraki.entities.SplashPageLogins;
import com.example.meraki.repositories.CustomersRepository;
import com.example.meraki.repositories.SplashPageLoginsRepository;
import com.example.meraki.services.response.CreateSplashPageLoginsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class SplashPageLoginsService {
    @Autowired
    private SplashPageLoginsRepository splashPageLoginsRepository;

    @Autowired
    private CustomersRepository customersRepository;


    public SplashPageLoginsService(SplashPageLoginsRepository splashPageLoginsRepository) {
        this.splashPageLoginsRepository = splashPageLoginsRepository;
    }

    public List<SplashPageLogins> getSplashPageLoginsById(long id){
        return splashPageLoginsRepository.findById(id);
    }


    public List<SplashPageLogins> getAllSplashPageLogins() {
        return splashPageLoginsRepository.findAll();
    }

    @Transactional
    public CreateSplashPageLoginsResponse CreateSplashPageLogins(CreateSplashPageLoginsRequestDTO createSplashPageLoginsRequestDTO) throws IOException {
        Customers customers1 = customersRepository.getReferenceById(createSplashPageLoginsRequestDTO.getCustomerID());
        SplashPageLogins splashPageLogins = new SplashPageLogins(
                customers1,
                createSplashPageLoginsRequestDTO.getSplashPageLogins().getLocation(),
                createSplashPageLoginsRequestDTO.getSplashPageLogins().getDate_time()
        );

        splashPageLoginsRepository.save(splashPageLogins);

        return new CreateSplashPageLoginsResponse(
                splashPageLogins,
                customers1
        );
    }


}
