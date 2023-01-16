package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.bundlesDTO.BundlesDTO;
import com.example.meraki.controllers.currencyDTO.CurrencyDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create bundle payload")
public class CreateCurrencyRequestDTO {

    private CurrencyDTO currency;

    private Long userID;

}


