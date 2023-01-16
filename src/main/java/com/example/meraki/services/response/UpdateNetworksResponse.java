package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateNetworksResponse {

    @ApiModelProperty(value = "network name", example = "")
    private String name;

    @ApiModelProperty(value = "active state", example = "")
    private Boolean active;
}
