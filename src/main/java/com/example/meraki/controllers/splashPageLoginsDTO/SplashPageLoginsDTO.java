package com.example.meraki.controllers.splashPageLoginsDTO;

import com.example.meraki.controllers.splashPageConnectionsDTO.SplashPageConnectionsDTO;
import com.example.meraki.entities.SplashPageLogins;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "splash_page_logins")
public class SplashPageLoginsDTO {

    @ApiModelProperty(value = "description of the role of the user. Required", required = true)
    private String location;

    @ApiModelProperty(value = "description of the role of the user. Required", required = true)
    private Date date_time;

    public static SplashPageLoginsDTO fromSplashPageLogins(SplashPageLoginsDTO splashPageLoginsDTO){
        return new SplashPageLoginsDTO(splashPageLoginsDTO.getLocation(),splashPageLoginsDTO.getDate_time());
    }
}
