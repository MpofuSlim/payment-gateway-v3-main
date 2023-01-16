package com.example.meraki.services.response;


import com.example.meraki.controllers.BatchDTO.BatchDTO;
import com.example.meraki.controllers.vouchersDTO.SellVouchersDTO;
import com.example.meraki.entities.Batch;
import com.example.meraki.entities.User;
import com.example.meraki.entities.Vouchers;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateSellVoucherResponse {

       //private Vouchers voucher;

      /*private User user;

      @ApiModelProperty(value = "The name of the batch", required = true, example = "1")
      private Long id;*/

      //@ApiModelProperty(value = "Is item active?", example = "true")
      //public Integer batchID;
      //private User user;

       @ApiModelProperty(value = "The name of the batch", required = true, example = "1")
       private Long id;

      public static CreateSellVoucherResponse fromSellVoucher(Vouchers voucher) {

             return new CreateSellVoucherResponse (voucher.getId());
      }

}
