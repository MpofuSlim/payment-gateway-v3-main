package com.example.meraki.controllers.salesDTO;

import com.example.meraki.entities.Sales;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "sales")

public class SalesDTO {

    @ApiModelProperty(value = "quantity", required = true, example = "10")
    private Integer quantity;

    public static SalesDTO fromSales(Sales sales) {
        return new SalesDTO(sales.getQuantity());
    }
}
