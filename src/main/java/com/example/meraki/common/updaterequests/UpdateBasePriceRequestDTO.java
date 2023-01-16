package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateBasePriceRequestDTO {

    @ApiModelProperty(value = "id of base price", example = "1")
    private Long id;

    @ApiModelProperty(value = "currency base price", example = "1.19")
    private Double price;
}
