package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.basePriceDTO.BasePriceDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "create base_price payload")
public class CreateBasePriceRequestDTO {

    private BasePriceDTO basePrice;

}
