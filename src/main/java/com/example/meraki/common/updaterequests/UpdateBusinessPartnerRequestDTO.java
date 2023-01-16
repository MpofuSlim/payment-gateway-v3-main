package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateBusinessPartnerRequestDTO {

    @ApiModelProperty(value = "id", example = "")
    private Long id;

    @ApiModelProperty(value = "partner name", example = "")
    private String name;

    @ApiModelProperty(value = "address", example = "")
    private String businessAddress;

    @ApiModelProperty(value = "partner's email", example = "")
    private String email;

    @ApiModelProperty(value = "phoneNumber", example = "")
    private String phoneNumber;

    @ApiModelProperty(value = "Id of voucher", example = "false")
    private Boolean active;
}
