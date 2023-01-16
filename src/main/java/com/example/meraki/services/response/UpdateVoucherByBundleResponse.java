package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UpdateVoucherByBundleResponse {

    @ApiModelProperty(value = "Id of bundle", example = "1")
    private Long bundleId;

    @ApiModelProperty(value = "sold status of bundle", example = "1")
    private Boolean sold;
}
