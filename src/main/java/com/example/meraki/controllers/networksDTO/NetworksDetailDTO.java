package com.example.meraki.controllers.networksDTO;

import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.controllers.organisationDTO.OrganisationDTO;
import com.example.meraki.entities.Organisations;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "networks detailed info")
public class NetworksDetailDTO {

    private NetworksDTO networks;

    private UserDTO user;

    private OrganisationDTO organisation;
}
