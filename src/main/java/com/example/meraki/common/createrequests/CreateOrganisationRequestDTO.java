package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.networksDTO.NetworksDTO;
import com.example.meraki.controllers.organisationDTO.OrganisationDTO;
import com.example.meraki.entities.Organisations;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "organisation payload")
public class CreateOrganisationRequestDTO {

    private OrganisationDTO organisation;

    private Long userID;

}
