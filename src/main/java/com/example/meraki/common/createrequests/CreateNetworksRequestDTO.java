package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.exchangeRateDTO.ExchangeRateDTO;
import com.example.meraki.controllers.networksDTO.NetworksDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Networks payload")

public class CreateNetworksRequestDTO {

    private NetworksDTO networks;

    private Long userID;

    private Long organisationsID;

}
