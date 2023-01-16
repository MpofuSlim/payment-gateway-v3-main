package com.example.meraki.controllers.splashPageActivitiesDTO;

import com.example.meraki.controllers.RoleDTO.RoleDTO;
import com.example.meraki.entities.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "splash_page_activities")
public class SplashPageActivitiesDTO {

    @ApiModelProperty(value = "description of the role of the user. Required", required = true)
    private Date date_time;

    public static SplashPageActivitiesDTO  fromSplashPageActivities(SplashPageActivitiesDTO  splashPageActivitiesDTO){
        return new SplashPageActivitiesDTO (splashPageActivitiesDTO.getDate_time());
    }

}
