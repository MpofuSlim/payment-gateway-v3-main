package com.example.meraki.Config.gateway;



public interface PaymentGatewayService {

    PaymentResponse initiate(final PaymentGatewayRequest request);

    default PaymentResponse failureResponse(final String message,
                                            final String tranReference,
                                            final String destinationResponseCode){
        return PaymentResponse.builder()
                .destinationReference("")
                .transactionReference(tranReference)
                .destinationResponseCode(destinationResponseCode)
                .message(message)
                .build();
    }
}
