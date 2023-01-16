package com.example.meraki.services;


import com.example.meraki.common.createrequests.CreateCurrencyRequestDTO;
import com.example.meraki.common.updaterequests.UpdateCurrencyRequestDTO;
import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.Currency;
import com.example.meraki.entities.User;
import com.example.meraki.repositories.CurrencyRepository;
import com.example.meraki.repositories.UserRepository;
import com.example.meraki.services.response.CreateCurrencyResponse;
import com.example.meraki.services.response.UpdateCurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;


@Service
public class CurrencyService {

    @Autowired
    public CurrencyRepository currencyRepository;

    @Autowired
    private UserRepository userRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public Currency getCurrency(Long id) {
        return currencyRepository.getReferenceById(id);
    }


    public List<Currency> getAllCurrency(){
        return currencyRepository.findAll();
    }

    @Transactional
    public CreateCurrencyResponse createCurrency(CreateCurrencyRequestDTO createCurrencyRequestDTO) throws IOException {
        User user1 = userRepository.getReferenceById(createCurrencyRequestDTO.getUserID());
        Currency currency = new Currency(
                user1,
                createCurrencyRequestDTO.getCurrency().getName(),
                createCurrencyRequestDTO.getCurrency().getDateCreated(),
                createCurrencyRequestDTO.getCurrency().getSymbol(),
                false
        );
        currencyRepository.save(currency);

        return new CreateCurrencyResponse(
                currency,
                user1
        );
    }

    public UpdateCurrencyResponse updateCurrency(UpdateCurrencyRequestDTO updateCurrencyRequestDTO) {

        Currency currency = currencyRepository.getReferenceById(updateCurrencyRequestDTO.getId());
        currency.setName(updateCurrencyRequestDTO.getName());
        currency.setSymbol(updateCurrencyRequestDTO.getSymbol());
        currency.setActive(updateCurrencyRequestDTO.getActive());


        currencyRepository.save(currency);

        UpdateCurrencyResponse updateCurrencyResponse = new UpdateCurrencyResponse(
                currency.getName(),
                currency.getSymbol(),
                currency.getActive()
        );

        return  updateCurrencyResponse;
    }

}
