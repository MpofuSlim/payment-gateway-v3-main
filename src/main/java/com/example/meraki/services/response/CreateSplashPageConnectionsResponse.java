package com.example.meraki.services.response;

import com.example.meraki.entities.Customers;
import com.example.meraki.entities.SplashPageActivities;
import com.example.meraki.entities.SplashPageConnections;
import com.example.meraki.entities.Vouchers;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateSplashPageConnectionsResponse {

    private SplashPageConnections splashPageConnections;
    private Customers customers;
    private Vouchers vouchers;
}
