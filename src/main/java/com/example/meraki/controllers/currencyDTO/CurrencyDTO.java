package com.example.meraki.controllers.currencyDTO;

import com.example.meraki.entities.Currency;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "currency")
public class CurrencyDTO {

    @ApiModelProperty(value = "name of the currency", required = true,example = "USD")
    private String name;

    @ApiModelProperty(value ="symbol of the currency-", required = true, example = "$")
    private String symbol;

    @ApiModelProperty(value ="Date created", required = true, example = "")
    private Date dateCreated;

    public static CurrencyDTO fromCurrency(Currency currency){
        return new CurrencyDTO(currency.getName(), currency.getSymbol(),currency.getDateCreated());
    }
}
