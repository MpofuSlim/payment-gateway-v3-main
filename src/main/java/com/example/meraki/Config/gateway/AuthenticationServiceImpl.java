package com.example.meraki.Config.gateway;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
@Data
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final RestTemplate restTemplate;

    private final AuthProperties authProperties;

    @Override
    @Cacheable("payment-gateway-token")
    public String getToken(){

        final HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add("grant_type", "password");
        map.add("client_id", authProperties.getClientId());
        map.add("client_secret", authProperties.getClientSecret());
        map.add("password", authProperties.getPassword());
        map.add("username", authProperties.getUsername());

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<AuthResponse> response = restTemplate.exchange(
                authProperties.getAuthUrl(),
                HttpMethod.POST,
                entity,
                AuthResponse.class);

        return response.getBody().getAccessToken();
    }
}
