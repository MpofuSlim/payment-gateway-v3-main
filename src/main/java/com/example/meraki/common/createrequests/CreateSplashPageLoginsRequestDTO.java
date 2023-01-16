package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.splashPageConnectionsDTO.SplashPageConnectionsDTO;
import com.example.meraki.controllers.splashPageLoginsDTO.SplashPageLoginsDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "splash_page_Logins payload")
public class CreateSplashPageLoginsRequestDTO {

    private SplashPageLoginsDTO splashPageLogins;

    private Long customerID;

}
