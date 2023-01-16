package com.example.meraki.controllers.customerDTO;

import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Customer detailed info")
public class CustomerDetailDTO {

    private CustomersDTO customers;


}
