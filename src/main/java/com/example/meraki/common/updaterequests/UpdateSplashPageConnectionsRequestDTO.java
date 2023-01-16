package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateSplashPageConnectionsRequestDTO {

    @ApiModelProperty(value = "id", example = "")
    private Long id;

    @ApiModelProperty(value = "location", example = "")
    private String location;

    @ApiModelProperty(value = "isConnected", example = "")
    private Boolean isConnected;
}
