package com.example.meraki.controllers.splashPageLoginsDTO;

import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.controllers.splashPageConnectionsDTO.SplashPageConnectionsDTO;
import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SplashPageLoginsDetailDTO {

    private SplashPageLoginsDTO splashPageLogins;

    private CustomersDTO customers;


}
