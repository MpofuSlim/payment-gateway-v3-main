package com.example.meraki.controllers.vouchersDTO;

import com.example.meraki.controllers.UserDTO.UserDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "sellVoucher detailed info")
public class SellVoucherDetailDTO {

    private SellVouchersDTO vouchers;

    //private UserDTO user;

}
