package com.example.meraki.services.response;

import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.BusinessPartner;
import com.example.meraki.entities.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateBusinessPartnerResponse {

    private BusinessPartner businessPartner;
}
