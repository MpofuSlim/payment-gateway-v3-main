package com.example.meraki.controllers.splashPageConnectionsDTO;

import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SplashPageConnectionDetailDTO {

    private SplashPageConnectionsDTO splashPageConnections;

    private CustomersDTO customers;

    private VouchersDTO vouchers;

}
