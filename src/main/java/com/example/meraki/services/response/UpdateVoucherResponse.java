package com.example.meraki.services.response;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateVoucherResponse {


    @ApiModelProperty(value = "vouchers approvedBy", example = "")
    private Integer approvedBy;

    @ApiModelProperty(value = "vouchers approved", example = "")
    private Integer approved;

    @ApiModelProperty(value = "blocked state", example = "")
    private Boolean isBlocked;

}


