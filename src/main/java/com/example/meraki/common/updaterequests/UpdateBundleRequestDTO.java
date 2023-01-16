package com.example.meraki.common.updaterequests;

import com.example.meraki.entities.BundleCategory;
import com.example.meraki.entities.Bundles;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateBundleRequestDTO {

    //CATEGORY, GROUP POLICY, CURRENCY

    @ApiModelProperty(value = "Id of bundle category", example = "1")
    private Long bundleCategoryId;

    @ApiModelProperty(value = "Id of currency", example = "1")
    private Long currencyId;

    @ApiModelProperty(value = "Id of bundle", example = "1")
    private Long id;

    @ApiModelProperty(value = "bundle name", example = "")
    private String name;

    @ApiModelProperty(value = "bundle description", example = "")
    private String description;

    @ApiModelProperty(value = "bundle image", example = "")
    private String image;

    @ApiModelProperty(value = "bundle price", example = "")
    private Double price;

    @ApiModelProperty(value = "Id of group policy", example = "1")
    private String groupPolicyId;

    @ApiModelProperty(value = "active state", example = "")
    private Boolean active = false;
}









