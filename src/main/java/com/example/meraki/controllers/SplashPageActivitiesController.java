package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateRoleRequestDTO;
import com.example.meraki.common.createrequests.CreateSplashPageActivitiesRequestDTO;
import com.example.meraki.entities.Role;
import com.example.meraki.entities.SplashPageActivities;
import com.example.meraki.services.SplashPageActivitiesService;
import com.example.meraki.services.response.CreateSplashPageActivitiesResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SplashPageActivitiesController {
    @Autowired
    private SplashPageActivitiesService splashPageActivitiesService;

    @CrossOrigin
    @GetMapping(path = "/splash_page_activities/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all SplashPageActivities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<SplashPageActivities>> listAllSplashPageActivities(
    ) {
        List<SplashPageActivities> splashPageActivities;

        splashPageActivities = splashPageActivitiesService.getAllSplashPageActivities();

        return new Response<>(ResponseCode.SUCCESS, "OK", splashPageActivities);
    }

    @CrossOrigin
    @PostMapping(path = "/splash_page_activities/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create SplashPageActivities ", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CreateSplashPageActivitiesResponse> createSplashPageActivities(
            @ApiParam(required = true) @RequestBody CreateSplashPageActivitiesRequestDTO createSplashPageActivitiesRequestDTO) {

        CreateSplashPageActivitiesResponse createSplashPageActivitiesResponse=splashPageActivitiesService.CreateSplashPageActivities(createSplashPageActivitiesRequestDTO);

        return new Response<>(ResponseCode.SUCCESS, "Ok", createSplashPageActivitiesResponse);

    }
}
