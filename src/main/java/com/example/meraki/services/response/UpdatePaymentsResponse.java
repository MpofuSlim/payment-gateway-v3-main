package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdatePaymentsResponse {

    @ApiModelProperty(value = "payment accounts", example = "")
    private Long paying_account;

    @ApiModelProperty(value = "payments location", example = "")
    private  String  location;

    @ApiModelProperty(value = "payment state", example = "")
    private Boolean active;
}

