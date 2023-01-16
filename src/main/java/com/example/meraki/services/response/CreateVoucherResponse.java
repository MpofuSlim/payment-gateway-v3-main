package com.example.meraki.services.response;

import com.example.meraki.entities.*;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Update voucher payload")
public class CreateVoucherResponse {


    private Vouchers vouchers;

    private User user;

    private Bundles bundles;

    private Batch batch;

    private Order order;
}
