package com.example.meraki.Config.gateway;

import org.springframework.cache.annotation.Cacheable;

public interface AuthenticationService {
    @Cacheable("payment_gateway_access_token")
    String getToken();
}
