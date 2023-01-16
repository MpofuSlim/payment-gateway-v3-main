package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateSplashPageConnectionsResponse {

    @ApiModelProperty(value = "location", example = "")
    private String location;

    @ApiModelProperty(value = "isConnected", example = "")
    private Boolean isConnected;
}
