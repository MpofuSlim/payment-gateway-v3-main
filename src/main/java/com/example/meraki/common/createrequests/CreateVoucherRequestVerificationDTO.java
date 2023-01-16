package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Voucher verification payload")

public class CreateVoucherRequestVerificationDTO {


    @ApiModelProperty(example = "8444-1950-6689-7924")
    private String voucherCode;





}
