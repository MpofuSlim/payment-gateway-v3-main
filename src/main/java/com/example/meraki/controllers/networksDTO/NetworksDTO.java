package com.example.meraki.controllers.networksDTO;

import com.example.meraki.controllers.exchangeRateDTO.ExchangeRateDTO;
import com.example.meraki.entities.ExchangeRate;
import com.example.meraki.entities.Networks;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "networks")
public class NetworksDTO {

    @ApiModelProperty(value ="rate name", required = true, example = "")
    private String name;

    @ApiModelProperty(value ="exchange_rate Date", required = true, example = "")
    private Date date_created;

    public static NetworksDTO  fromNetworks(Networks networks){
        return new NetworksDTO (networks.getName(),networks.getDate_created());
    }
}
