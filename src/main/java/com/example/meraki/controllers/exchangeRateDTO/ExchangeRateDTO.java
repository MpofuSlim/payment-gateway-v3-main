package com.example.meraki.controllers.exchangeRateDTO;

import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.entities.Customers;
import com.example.meraki.entities.ExchangeRate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "exchange_rate")
public class ExchangeRateDTO {

    @ApiModelProperty(value ="rate name", required = true, example = "")
    private String name;

    @ApiModelProperty(value ="rate", required = true, example = "")
    private Double rate;

    @ApiModelProperty(value ="exchange_rate Date", required = true, example = "")
    private Date date_created;


    public static ExchangeRateDTO fromExchangeRate(ExchangeRate exchangeRate){
        return new ExchangeRateDTO(exchangeRate.getName(),exchangeRate.getRate(),exchangeRate.getDate_created());
    }
}

