package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdatePaymentsRequestDTO {

    @ApiModelProperty(value = "payment id", example = "")
    private Long id;

    @ApiModelProperty(value = "payment accounts", example = "")
    private Long paying_account;

    @ApiModelProperty(value = "payments location", example = "")
    private  String  location;

    @ApiModelProperty(value = "payment state", example = "")
    private Boolean active;
}
