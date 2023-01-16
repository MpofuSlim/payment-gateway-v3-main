package com.example.meraki.services.response;


import com.example.meraki.entities.BundleCategory;
import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.Currency;
import com.example.meraki.entities.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateBundlesResponse {

    private Bundles bundles;
    private User user;
    private Currency currency;
    private BundleCategory bundleCategory;

}



