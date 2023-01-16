package com.example.meraki.controllers.customerDTO;

import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import com.example.meraki.entities.Customers;
import com.example.meraki.entities.User;
import com.example.meraki.entities.Vouchers;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "voucher")
public class CustomersDTO {

    @ApiModelProperty(value ="voucher batchID", required = true, example = "")
    private Long id;

    @ApiModelProperty(value ="voucher batchID", required = true, example = "")
    private String firstname;

    @ApiModelProperty(value ="voucher batchName", required = true, example = "")
    private String surname;

    @ApiModelProperty(value ="voucherCode", required = true, example = "")
    private String phone_number;

    @ApiModelProperty(value ="email", required = true, example = "")
    private String email;

    @ApiModelProperty(value ="password", required = true, example = "")
    private String password;

    public static CustomersDTO fromCustomer(Customers customers){
        return new CustomersDTO(customers.getId(), customers.getFirstname(),customers.getSurname(),customers.getPhone_number(),customers.getEmail(), customers.getPassword());
    }
}


