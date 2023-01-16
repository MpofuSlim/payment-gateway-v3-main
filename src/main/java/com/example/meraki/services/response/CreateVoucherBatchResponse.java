package com.example.meraki.services.response;


import com.example.meraki.entities.Batch;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "create voucher-batch")
public class CreateVoucherBatchResponse {

    private Batch batch;

}
