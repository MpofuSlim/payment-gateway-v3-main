package com.example.meraki.common.updaterequests;

import com.example.meraki.Config.gateway.PaymentStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateCustomersPaymentRequestDTO {

    @ApiModelProperty(value = "customer id", example = "")
    private Long id;

    @ApiModelProperty(value = "payment status", example = "")
    private PaymentStatus status;

}
