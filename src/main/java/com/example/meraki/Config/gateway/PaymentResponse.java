package com.example.meraki.Config.gateway;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class PaymentResponse  extends PaymentRequest {
    private String message;
    private String destinationReference;
    private String destinationResponseCode;
    private String gatewayReference;
}