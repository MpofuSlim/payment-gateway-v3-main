package com.example.meraki.services.response;

import com.example.meraki.entities.ExchangeRate;
import com.example.meraki.entities.ExchangeRateExpired;
import com.example.meraki.entities.User;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "exchange-rate-expired  payload")
public class CreateExchangeRateExpiredResponse {

    private ExchangeRateExpired exchangeRateExpired;

    private User user;
}
