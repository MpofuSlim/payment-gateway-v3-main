package com.example.meraki.Config.gateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "auth")
@Data
public class AuthProperties {
    private String clientId;
    private String clientSecret;
    private String username;
    private String password;
    private String authUrl;
}
