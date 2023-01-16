package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateBatchRequestDTO {

    @ApiModelProperty(value = "Id of voucher", example = "1")
    private Long id;

    @Column(name = "batchName", nullable = false)
    private String batchName;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

}