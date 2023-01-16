package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateExchangeRateResponse {

    @ApiModelProperty(value = "firstname", example = "")
    private String name;

    @ApiModelProperty(value = "rate", example = "")
    private Double rate;

}



