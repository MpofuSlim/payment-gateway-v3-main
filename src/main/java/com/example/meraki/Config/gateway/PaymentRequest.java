package com.example.meraki.Config.gateway;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@SuperBuilder
@Data
@JsonInclude(NON_EMPTY)
@NoArgsConstructor
public class PaymentRequest implements Serializable {

    private List<MetaData> creditParty;

    private List<MetaData> debitParty;

    private BigDecimal amount;

    private String currency;

    private String transactionReference;

    private String originalTransactionReference;

    private String type;

    private PaymentStatus transactionStatus;

    private String remarks;

    private List<MetaData> metadata;

    private String notifyUrl;

}
