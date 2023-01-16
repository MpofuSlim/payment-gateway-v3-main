package com.example.meraki.services.response;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Update voucher payload")
public class CreateVoucherVerificationResponse {


    private String groupPolicyId;
    private Integer duration;
    private Long voucherId;


}
