package com.example.meraki.common.updaterequests;

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
public class UpdateCurrencyRequestDTO {

    @ApiModelProperty(value = "currency id", example = "")
    private Long id;

    @ApiModelProperty(value = "currency name", example = "")
    private String name;

    @ApiModelProperty(value = "currency symbol", example = "")
    private String symbol;

    @ApiModelProperty(value = "currency state", example = "")
    private Boolean active;
}
