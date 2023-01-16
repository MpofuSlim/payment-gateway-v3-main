package com.example.meraki.Config.gateway;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentGatewayRequest {
	private String msisdn;
	private BigDecimal amount;
	private String currencyCode;
	private String reference;
	private String remarks;
}
