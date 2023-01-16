package com.example.meraki.services.response;

import com.example.meraki.entities.ExchangeRate;
import com.example.meraki.entities.Networks;
import com.example.meraki.entities.Organisations;
import com.example.meraki.entities.User;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "networks  payload")
public class CreateNetworksResponse {

    private Networks networks;

    private User user;

    private Organisations organisations;
}
