package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateCurrencyResponse {
    @ApiModelProperty(value = "currency name", example = "")
    private String name;

    @ApiModelProperty(value = "currency symbol", example = "")
    private String symbol;

    @ApiModelProperty(value = "currency state", example = "")
    private Boolean active;
}
