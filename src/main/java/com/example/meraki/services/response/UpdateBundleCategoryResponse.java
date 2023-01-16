package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateBundleCategoryResponse {

    @ApiModelProperty(value = "vouchers approvedBy", example = "")
    private String name;

    @ApiModelProperty(value = "vouchers approved", example = "")
    private String description;

    @ApiModelProperty(value = "active state", example = "")
    private Boolean active;
}