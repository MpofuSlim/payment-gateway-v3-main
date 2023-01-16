package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.exchangeRateDTO.ExchangeRateDTO;
import com.example.meraki.controllers.exchangeRateExpiredDTO.ExchangeRateExpiredDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create Exchange-Rate payload")
public class CreateExchangeRateExpiredRequestDTO {

    private ExchangeRateExpiredDTO exchangeRateExpired;

    private Long userID;
}
