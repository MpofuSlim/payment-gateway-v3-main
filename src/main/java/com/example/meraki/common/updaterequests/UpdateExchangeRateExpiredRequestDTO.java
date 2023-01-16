package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateExchangeRateExpiredRequestDTO {

    @ApiModelProperty(value = "id", example = "")
    private Long id;

    @ApiModelProperty(value = "rate", example = "")
    private Double rate;

}
