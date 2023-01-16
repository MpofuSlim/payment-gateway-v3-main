package com.example.meraki.Config.gateway;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ecocash")
@Data
public class EcocashConfig {
    private String msisdnRegex;
    private String merchantCode;
    private String accountName;
    private String merchantMsisdn;
    private String merchantPin;
}
