package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateAdminPortalUsersRolesRequestDTO {
    @ApiModelProperty(value = "Id of voucher", example = "1")
    private Long id;

    @ApiModelProperty(value = "firstName", example = "")
    private String name;

    @ApiModelProperty(value = "date-created", example = "")
    private Date date_created;

    @ApiModelProperty(value = "active state", example = "")
    private Boolean active = false;
}
