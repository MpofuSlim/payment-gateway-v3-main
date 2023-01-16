package com.example.meraki.services.response;

import com.example.meraki.entities.Vouchers;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateSellBatchResponse {

    @ApiModelProperty(value = "The name of the batch", required = true, example = "1")
    private Long id;

    @ApiModelProperty(value = "Is item active?", example = "true")
    public Boolean active;
}
