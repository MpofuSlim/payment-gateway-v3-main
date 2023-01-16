package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateCustomerRequestDTO;
import com.example.meraki.common.createrequests.CreateExchangeRateRequestDTO;
import com.example.meraki.common.updaterequests.UpdateExchangeRateRequestDTO;
import com.example.meraki.entities.Customers;
import com.example.meraki.entities.ExchangeRate;
import com.example.meraki.entities.User;
import com.example.meraki.repositories.CustomersRepository;
import com.example.meraki.repositories.ExchangeRateRepository;
import com.example.meraki.repositories.UserRepository;
import com.example.meraki.services.response.CreateCustomerResponse;
import com.example.meraki.services.response.CreateExchangeRateResponse;
import com.example.meraki.services.response.UpdateExchangeRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ExchangeRateService {
    @Autowired
    private ExchangeRateRepository exchangeRateRepository;
    @Autowired
    private UserRepository userRepository;

    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public ExchangeRate getExchangeRate(Long id) {
        return exchangeRateRepository.getReferenceById(id);
    }

    public List<ExchangeRate> getAllExchangeRates(){
        return exchangeRateRepository.findAll();
    }
    public CreateExchangeRateResponse createExchangeRate(CreateExchangeRateRequestDTO createExchangeRateRequestDTO) throws IOException {
        User user1 = userRepository.getReferenceById(createExchangeRateRequestDTO.getUserID());
        ExchangeRate exchangeRate = new ExchangeRate(
                user1,
                createExchangeRateRequestDTO.getExchangeRate().getName(),
                createExchangeRateRequestDTO.getExchangeRate().getRate(),
                createExchangeRateRequestDTO.getExchangeRate().getDate_created()
        );

        exchangeRateRepository.save(exchangeRate);

        return new CreateExchangeRateResponse(
                exchangeRate,
                user1
        );
    }

    public UpdateExchangeRateResponse updateExchangeRate(UpdateExchangeRateRequestDTO updateExchangeRateRequestDTO) {

        ExchangeRate exchangeRate = exchangeRateRepository.getReferenceById(updateExchangeRateRequestDTO.getId());
        exchangeRate.setName(updateExchangeRateRequestDTO.getName());
        exchangeRate.setRate(updateExchangeRateRequestDTO.getRate());

        exchangeRateRepository.save(exchangeRate);

        UpdateExchangeRateResponse updateExchangeRateResponse = new UpdateExchangeRateResponse(
                exchangeRate.getName(),
                exchangeRate.getRate()

        );

        return  updateExchangeRateResponse;
    }
}
