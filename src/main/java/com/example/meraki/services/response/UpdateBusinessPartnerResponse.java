package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateBusinessPartnerResponse {

    @ApiModelProperty(value = "partner name", example = "")
    private String name;

    @ApiModelProperty(value = "address", example = "")
    private String businessAddress;

    @ApiModelProperty(value = "partner's email", example = "")
    private String email;

    @ApiModelProperty(value = "phoneNumber", example = "")
    private String phoneNumber;

    @ApiModelProperty(value = "Id of voucher", example = "")
    private Boolean active;
}
