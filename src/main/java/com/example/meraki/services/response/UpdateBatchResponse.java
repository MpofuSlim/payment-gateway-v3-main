package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateBatchResponse {

    @ApiModelProperty(value = "firstName", example = "")
    private String batchName;

    @ApiModelProperty(value = "active state", example = "")
    private Boolean active;
}
