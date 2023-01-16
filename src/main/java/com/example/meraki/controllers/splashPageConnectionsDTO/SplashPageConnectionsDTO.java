package com.example.meraki.controllers.splashPageConnectionsDTO;

import com.example.meraki.controllers.splashPageActivitiesDTO.SplashPageActivitiesDTO;
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
@ApiModel(description = "splash_page_connections")
public class SplashPageConnectionsDTO {

    @ApiModelProperty(value = "description of the role of the user. Required", required = true)
    private Date connection_time;

    @ApiModelProperty(value = "description of the role of the user. Required", required = true)
    private String location;

    @ApiModelProperty(value = "description of the role of the user. Required", required = true)
    private Boolean isConnected;

    public static SplashPageConnectionsDTO fromSplashPageConnections(SplashPageConnectionsDTO  splashPageConnectionsDTO){
        return new SplashPageConnectionsDTO(splashPageConnectionsDTO.getConnection_time(),splashPageConnectionsDTO.getLocation(),splashPageConnectionsDTO.getIsConnected());
    }
}
