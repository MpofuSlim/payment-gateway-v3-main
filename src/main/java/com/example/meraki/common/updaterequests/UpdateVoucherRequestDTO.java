package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateVoucherRequestDTO {

    @ApiModelProperty(value = "Id of voucher", example = "1")
    private Long id;

    @ApiModelProperty(value = "vouchers approvedBy", example = "")
    private Integer approvedBy;

    @ApiModelProperty(value = "vouchers approved", example = "")
    private Integer approved;

    @ApiModelProperty(value = "", example = "")
    private Boolean isBlocked;


}

