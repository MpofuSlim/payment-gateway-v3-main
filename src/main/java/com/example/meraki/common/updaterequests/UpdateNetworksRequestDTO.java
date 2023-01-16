package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateNetworksRequestDTO {

    @ApiModelProperty(value = "Id of network", example = "1")
    private Long id;

    @ApiModelProperty(value = "network name", example = "")
    private String name;

    @ApiModelProperty(value = "", example = "")
    private Boolean active;
}
