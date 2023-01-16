package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateExchangeRateExpiredResponse {

    @ApiModelProperty(value = "rate", example = "")
    private Double rate;

}
