package com.example.meraki.controllers.exchangeRateExpiredDTO;

import com.example.meraki.controllers.exchangeRateDTO.ExchangeRateDTO;
import com.example.meraki.entities.ExchangeRate;
import com.example.meraki.entities.ExchangeRateExpired;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "exchange_rate_expired")
public class ExchangeRateExpiredDTO {

    @ApiModelProperty(value ="rate", required = true, example = "")
    private Double rate;

    @ApiModelProperty(value ="exchange_rate Date", required = true, example = "")
    private Date date_created;


    public static ExchangeRateExpiredDTO fromExchangeRateExpired(ExchangeRateExpired exchangeRateExpired){
        return new ExchangeRateExpiredDTO(exchangeRateExpired.getRate(),exchangeRateExpired.getDate_created());
    }
}
