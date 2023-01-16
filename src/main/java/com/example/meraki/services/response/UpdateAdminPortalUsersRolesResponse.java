package com.example.meraki.services.response;

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
public class UpdateAdminPortalUsersRolesResponse {

    @ApiModelProperty(value = "name", example = "")
    private String name;

    @ApiModelProperty(value = "date", example = "")
    private Date date_created;

    @ApiModelProperty(value = "state", example = "")
    private Boolean active;
}

