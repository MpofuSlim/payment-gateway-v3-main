package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.BatchDTO.BatchDTO;
import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create sellBatch")
public class CreateSellBatchRequestDTO {
    private BatchDTO batch;

    //private Long voucherID;
}
