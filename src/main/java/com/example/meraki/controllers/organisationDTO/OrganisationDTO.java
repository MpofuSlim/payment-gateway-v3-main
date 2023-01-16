package com.example.meraki.controllers.organisationDTO;

import com.example.meraki.entities.Organisations;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "organisations")
public class OrganisationDTO {
    @ApiModelProperty(value ="rate name", required = true, example = "")
    private String name;

    @ApiModelProperty(value ="exchange_rate Date", required = true, example = "")
    private Date date_created;

    public static OrganisationDTO fromOrganisations(Organisations organisations){
        return new OrganisationDTO (organisations.getName(),organisations.getDate_created());
    }
}
