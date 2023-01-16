package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import com.example.meraki.entities.Customers;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create vouchers payload")
public class CreateCustomerRequestDTO {

    private CustomersDTO customers;


    //private Long voucherID;

    //private Long batchId;
}
