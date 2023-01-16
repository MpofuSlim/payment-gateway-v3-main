package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateExchangeRateExpiredRequestDTO;
import com.example.meraki.common.createrequests.CreateExchangeRateRequestDTO;
import com.example.meraki.common.updaterequests.UpdateExchangeRateExpiredRequestDTO;
import com.example.meraki.entities.Currency;
import com.example.meraki.entities.ExchangeRate;
import com.example.meraki.entities.ExchangeRateExpired;
import com.example.meraki.entities.User;
import com.example.meraki.repositories.CurrencyRepository;
import com.example.meraki.repositories.ExchangeRateExpiredRepository;
import com.example.meraki.repositories.ExchangeRateRepository;
import com.example.meraki.repositories.UserRepository;
import com.example.meraki.services.response.CreateExchangeRateExpiredResponse;
import com.example.meraki.services.response.CreateExchangeRateResponse;
import com.example.meraki.services.response.UpdateExchangeRateExpiredResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ExchangeRateExpiredService {
    @Autowired
    private ExchangeRateExpiredRepository exchangeRateExpiredRepository;
    @Autowired
    private UserRepository userRepository;

    public ExchangeRateExpiredService( ExchangeRateExpiredRepository exchangeRateExpiredRepository) {
        this.exchangeRateExpiredRepository = exchangeRateExpiredRepository;
    }

    public ExchangeRateExpired getExchangeRateExpired(Long id) {
        return exchangeRateExpiredRepository.getReferenceById(id);
    }

    public List<ExchangeRateExpired> getAllExchangeRatesExpired() {return exchangeRateExpiredRepository.findAll();}

    public CreateExchangeRateExpiredResponse createExchangeRateExpired(CreateExchangeRateExpiredRequestDTO createExchangeRateExpiredRequestDTO) throws IOException {
        User user1 = userRepository.getReferenceById(createExchangeRateExpiredRequestDTO.getUserID());
        ExchangeRateExpired exchangeRateExpired = new ExchangeRateExpired(
                user1,
                createExchangeRateExpiredRequestDTO.getExchangeRateExpired().getRate(),
                createExchangeRateExpiredRequestDTO.getExchangeRateExpired().getDate_created()
        );

        exchangeRateExpiredRepository.save(exchangeRateExpired);

        return new CreateExchangeRateExpiredResponse(
                exchangeRateExpired,
                user1
        );
    }

    public UpdateExchangeRateExpiredResponse updateExchangeRateExpired(UpdateExchangeRateExpiredRequestDTO updateExchangeRateExpiredRequestDTO) {

        ExchangeRateExpired exchangeRateExpired = exchangeRateExpiredRepository.getReferenceById(updateExchangeRateExpiredRequestDTO.getId());
        exchangeRateExpired.setRate(updateExchangeRateExpiredRequestDTO.getRate());

        exchangeRateExpiredRepository.save(exchangeRateExpired);

        UpdateExchangeRateExpiredResponse updateExchangeRateExpiredResponse = new UpdateExchangeRateExpiredResponse(
                exchangeRateExpired.getRate()

        );

        return  updateExchangeRateExpiredResponse;
    }
}
