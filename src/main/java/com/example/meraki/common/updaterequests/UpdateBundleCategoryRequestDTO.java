package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateBundleCategoryRequestDTO {

    @ApiModelProperty(value = "Id of voucher", example = "1")
    private Long id;

    @ApiModelProperty(value = "category name", example = "")
    private String name;

    @ApiModelProperty(value = "duration", example = "")
    private Integer duration;

    @ApiModelProperty(value = "description", example = "")
    private String description;

    @ApiModelProperty(value = "active state", example = "")
    private Boolean active = false;
}
