package com.example.meraki.Config.gateway;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

import static com.example.meraki.Config.gateway.PaymentGatewayConstants.AccountIdentifier.*;
import static com.example.meraki.Config.gateway.PaymentGatewayConstants.MetaData.NOTIFICATION_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@Service
public class PaymentGatewayServiceImpl implements PaymentGatewayService {

    private final RestTemplate restTemplate;
    private final EcocashConfig ecocashConfig;
    private final AuthenticationService authenticationService;
    private final PaymentGatewayProperties paymentGatewayProperties;

    public PaymentGatewayServiceImpl(RestTemplate restTemplate,
                                     EcocashConfig ecocashConfig,
                                     AuthenticationService authenticationService,
                                     PaymentGatewayProperties paymentGatewayProperties) {
        this.restTemplate = restTemplate;
        this.ecocashConfig = ecocashConfig;
        this.authenticationService = authenticationService;
        this.paymentGatewayProperties = paymentGatewayProperties;
    }

    public PaymentResponse initiate(final PaymentGatewayRequest gatewayRequest) {

        final MetaData msisdnData = new MetaData(MSISDN, gatewayRequest.getMsisdn());

        final List<MetaData> debitParty = Arrays.asList(msisdnData);

        List<MetaData> creditParty;

        if(gatewayRequest.getMsisdn().matches(ecocashConfig.getMsisdnRegex())) {
            creditParty = Arrays.asList(new MetaData(IDENTITY_ALIAS, ecocashConfig.getMerchantCode()),
                    new MetaData(ACCOUNT_NAME, ecocashConfig.getAccountName()),
                    new MetaData(MSISDN, ecocashConfig.getMerchantMsisdn()),
                    new MetaData(ACCOUNT_PASS_KEY, ecocashConfig.getMerchantPin()));
        }
        else {
            creditParty = Arrays.asList(new MetaData(IDENTITY_ALIAS, ecocashConfig.getMerchantCode()));
        }

        final List<MetaData> metaData = Arrays.asList(new MetaData(NOTIFICATION_TYPE, paymentGatewayProperties.getNotifyType()));

        final PaymentRequest request = PaymentRequest.builder()
                .amount(gatewayRequest.getAmount())
                .currency(gatewayRequest.getCurrencyCode())
                .transactionReference(gatewayRequest.getReference())
                .debitParty(debitParty)
                .creditParty(creditParty)
                .metadata(metaData)
                .remarks(gatewayRequest.getRemarks())
                .notifyUrl(paymentGatewayProperties.getNotifyUri())
                .build();

        try {
            log.info("processing payment: {}", request);
            final HttpEntity<PaymentRequest> postPaymentEntity = new HttpEntity<>(request, getHttpHeaders());
            final ResponseEntity<PaymentResponse> exchange = restTemplate.exchange(
                    paymentGatewayProperties.getEndpointUrl(),
                    HttpMethod.POST,
                    postPaymentEntity,
                    PaymentResponse.class);

            return exchange.getBody();
        }
        catch (Exception ex){
            log.error("", ex);
            return failureResponse(StringUtils.left(ex.getMessage(),200),
                    gatewayRequest.getReference(),String.valueOf(PaymentStatus.FAILED.getStatusCode()));
        }
    }

    private HttpHeaders getHttpHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        final String token = authenticationService.getToken();
        headers.setBearerAuth(token);
        headers.setAccept(Arrays.asList(APPLICATION_JSON));
        return headers;
    }

}
