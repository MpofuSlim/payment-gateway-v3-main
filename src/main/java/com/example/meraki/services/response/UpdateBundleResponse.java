package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateBundleResponse {

    @ApiModelProperty(value = "Id of bundle", example = "1")
    private Long bundleCategoryId;

    @ApiModelProperty(value = "Id of currency", example = "1")
    private Long currencyId;

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
    private Boolean active;
}
