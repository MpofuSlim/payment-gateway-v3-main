package com.example.meraki.services.response;

import com.example.meraki.entities.Customers;
import com.example.meraki.entities.SplashPageLogins;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateSplashPageLoginsResponse {

    private SplashPageLogins splashPageLogins;
    private Customers customers;
}
