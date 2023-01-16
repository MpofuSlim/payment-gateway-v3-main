package com.example.meraki.controllers.vouchersDTO;

import com.example.meraki.controllers.BatchDTO.BatchDTO;
import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.bundlesDTO.BundlesDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Voucher detailed info")
public class VoucherBatchDetailDTO {

    private VouchersDTO vouchers;

    private UserDTO user;

    private BundlesDTO bundles;

    private BatchDTO batch;
}
