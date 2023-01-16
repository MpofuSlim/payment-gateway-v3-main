package com.example.meraki.services.response;

import com.example.meraki.controllers.exchangeRateDTO.ExchangeRateDTO;
import com.example.meraki.entities.Customers;
import com.example.meraki.entities.ExchangeRate;
import com.example.meraki.entities.User;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "exchange-rate  payload")
public class CreateExchangeRateResponse {

    private ExchangeRate exchangeRate;

    private User user;
}
