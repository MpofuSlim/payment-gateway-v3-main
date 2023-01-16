package com.example.meraki.controllers.businessPartnerDTO;

import com.example.meraki.controllers.bundlesDTO.BundlesDTO;
import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.BusinessPartner;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "business_partner")
public class BusinessPartnerDTO {

    @ApiModelProperty(value = "name of business partner", example = "")
    private String name;

    @ApiModelProperty(value = "business-address", example = "")
    private String businessAddress;

    @ApiModelProperty(value = "email", example = "")
    private String email;

    @ApiModelProperty(value = "phone number", example = "")
    private String phoneNumber;

    @ApiModelProperty(value = "true/false", example = "")
    private Boolean active;


    public static BusinessPartnerDTO  fromBusinessPartner(BusinessPartner businessPartner) {
        return new BusinessPartnerDTO (businessPartner.getName(), businessPartner.getBusinessAddress(), businessPartner.getEmail(), businessPartner.getPhoneNumber(),businessPartner.getActive());

    }

}
