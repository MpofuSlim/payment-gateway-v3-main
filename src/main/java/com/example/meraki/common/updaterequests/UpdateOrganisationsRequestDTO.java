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
public class UpdateOrganisationsRequestDTO {

    @ApiModelProperty(value = "organisation id", example = "")
    private Long id;

    @ApiModelProperty(value = "organisation name", example = "")
    private String name;

    @ApiModelProperty(value = "organisation state", example = "")
    private Boolean active;
}
