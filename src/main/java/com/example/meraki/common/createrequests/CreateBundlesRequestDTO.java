package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.bundlesDTO.BundlesDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@ApiModel(description = "Create bundle payload")
public class CreateBundlesRequestDTO {

    private BundlesDTO bundle;

    private Long userID;

    private Long currencyID;

    private Long bundleCategoryID;


}
