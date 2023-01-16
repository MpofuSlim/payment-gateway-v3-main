package com.example.meraki.common.createrequests;


import com.example.meraki.controllers.currencyDTO.CurrencyDTO;
import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create vouchers payload")
public class CreateVoucherRequestDTO {

    private VouchersDTO vouchers;

    private Long userID;

    private Long bundleID;

    private Long batchID;

    private Long orderId;


}
