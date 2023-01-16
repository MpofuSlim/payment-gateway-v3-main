package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.bundlesDTO.BundleCategoryDTO;
import com.example.meraki.controllers.currencyDTO.CurrencyDTO;
import com.example.meraki.entities.BundleCategory;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create bundle payload")
public class CreateBundleCategoryRequestDTO {

    private BundleCategoryDTO bundleCategory;

    private Long userID;
}
