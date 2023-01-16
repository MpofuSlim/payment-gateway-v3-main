package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateExchangeRateRequestDTO {

    @ApiModelProperty(value = "id", example = "")
    private Long id;

    @ApiModelProperty(value = "firstname", example = "")
    private String name;

    @ApiModelProperty(value = "rate", example = "")
    private Double rate;

}
