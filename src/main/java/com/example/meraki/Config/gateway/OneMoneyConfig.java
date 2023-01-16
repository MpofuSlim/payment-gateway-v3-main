package com.example.meraki.Config.gateway;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "onemoney")
public class OneMoneyConfig {
    private String msisdnRegex;
    private String merchantCode;

    public String getMsisdnRegex() {
        return msisdnRegex;
    }

    public void setMsisdnRegex(String msisdnRegex) {
        this.msisdnRegex = msisdnRegex;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }
}
