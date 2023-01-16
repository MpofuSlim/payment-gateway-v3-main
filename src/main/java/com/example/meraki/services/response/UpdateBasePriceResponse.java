package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateBasePriceResponse {

    @ApiModelProperty(value = "currency base price", example = "1.19")
    private Double price;
}
