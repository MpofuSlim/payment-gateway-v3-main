package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.controllers.exchangeRateDTO.ExchangeRateDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create Exchange-Rate payload")

public class CreateExchangeRateRequestDTO {

    private ExchangeRateDTO exchangeRate;

    private Long userID;
}
