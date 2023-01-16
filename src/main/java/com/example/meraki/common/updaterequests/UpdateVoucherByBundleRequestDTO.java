package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UpdateVoucherByBundleRequestDTO {


    @ApiModelProperty(value = "Id of voucher", example = "1")
    private Long voucherId;

    @ApiModelProperty(value = "sold status of bundle", example = "1")
    private Boolean sold;


}
