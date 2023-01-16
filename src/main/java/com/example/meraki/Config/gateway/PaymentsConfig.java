package com.example.meraki.Config.gateway;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(value = {
        EcocashConfig.class,
        OneMoneyConfig.class,
        AuthProperties.class,
        PaymentGatewayProperties.class})
public class PaymentsConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
