package com.example.meraki.controllers.paymentsDTO;

import com.example.meraki.controllers.organisationDTO.OrganisationDTO;
import com.example.meraki.entities.Organisations;
import com.example.meraki.entities.Payments;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "payments")
public class PaymentsDTO {

    @ApiModelProperty(value ="amount paid", required = true, example = "")
    private Double amountPaid;

    @ApiModelProperty(value ="Date paid", required = true, example = "")
    private Date datePaid;

    @ApiModelProperty(value ="paid account", required = true, example = "")
    private Long paying_account;

    @ApiModelProperty(value ="location", required = true, example = "")
    private  String  location;

    public static  PaymentsDTO fromPayments(Payments payments){
        return new  PaymentsDTO(payments.getAmountPaid(),payments.getDatePaid(),payments.getPaying_account(),payments.getLocation());
    }
}

