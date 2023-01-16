package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.splashPageActivitiesDTO.SplashPageActivitiesDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "splash_page_activities payload")
public class CreateSplashPageActivitiesRequestDTO {

    private SplashPageActivitiesDTO splashPageActivities;
}
