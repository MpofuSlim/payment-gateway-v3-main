package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.splashPageActivitiesDTO.SplashPageActivitiesDTO;
import com.example.meraki.controllers.splashPageConnectionsDTO.SplashPageConnectionsDTO;
import com.example.meraki.entities.SplashPageConnections;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "splash_page_connections payload")
public class CreateSplashPageConnectionsRequestDTO {

    private SplashPageConnectionsDTO splashPageConnections;

    private Long customerID;
    private Long voucherID;
}
