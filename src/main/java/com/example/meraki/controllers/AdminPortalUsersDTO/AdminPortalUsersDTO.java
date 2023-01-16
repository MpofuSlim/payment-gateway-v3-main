package com.example.meraki.controllers.AdminPortalUsersDTO;

import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.Vouchers;
import io.swagger.annotations.ApiModel;
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
@ApiModel(description = "AdminPortalUsers")
public class AdminPortalUsersDTO {

    @ApiModelProperty(value ="first name of the user", required = true, example = "Tawanda")
    private String firstname;

    @ApiModelProperty(value ="surname of the user", required = true, example = "Mpofu")
    private String surname;

    @ApiModelProperty(value ="email address", required = true, example = "test@gmail.com")
    private String email_address;

    @ApiModelProperty(value ="password", required = true, example = "twdgfths")
    private String password;


    public static  AdminPortalUsersDTO fromAdminPortalUsers(AdminPortalUsers adminPortalUsers){
        return new AdminPortalUsersDTO (adminPortalUsers.getFirstname(),adminPortalUsers.getSurname(),adminPortalUsers.getEmailAddress(), adminPortalUsers.getPassword());
    }

}

