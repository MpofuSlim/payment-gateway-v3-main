package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.bundlesDTO.BundlesDTO;
import com.example.meraki.controllers.businessPartnerDTO.BusinessPartnerDTO;
import com.example.meraki.entities.BusinessPartner;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "create business_partner")
public class CreateBusinessPartnerRequestDTO {

    private BusinessPartnerDTO businessPartner;

}
