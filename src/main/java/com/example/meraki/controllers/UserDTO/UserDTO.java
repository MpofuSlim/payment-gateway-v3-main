package com.example.meraki.controllers.UserDTO;

import com.example.meraki.controllers.currencyDTO.CurrencyDTO;
import com.example.meraki.entities.Currency;
import com.example.meraki.entities.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "bundle")
public class UserDTO {

    @ApiModelProperty(value = "user phone number", required = true,example = "email")
    private String email;

    @ApiModelProperty(value ="user phoneNumber", required = true, example = "")
    private String phoneNumber;

    @ApiModelProperty(value ="user firstName", required = true, example = "")
    private String firstname;

    @ApiModelProperty(value ="user surname", required = true, example = "")
    private String surname;

    @ApiModelProperty(value ="user password", required = true, example = "")
    private String password;



    public static UserDTO fromUser(User user){
        return new UserDTO(user.getEmail(),user.getPhoneNumber(),user.getFirstname(),user.getSurname(), user.getPassword());
    }
}



