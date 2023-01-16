package com.example.meraki.controllers.basePriceDTO;

import com.example.meraki.entities.BasePrice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "base_price")
public class BasePriceDTO {

    @ApiModelProperty(value = "", example = "1")
    private Long id;

    @ApiModelProperty(value = "", example = "")
    private Double price;


    public static BasePriceDTO fromBasePrice(BasePrice basePrice) {

        return new BasePriceDTO(basePrice.getId(), basePrice.getPrice());
    }
}
