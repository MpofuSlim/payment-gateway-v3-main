package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateOrganisationsResponse {

    @ApiModelProperty(value = "organisation name", example = "")
    private String name;

    @ApiModelProperty(value = "organisation state", example = "")
    private Boolean active;

}

