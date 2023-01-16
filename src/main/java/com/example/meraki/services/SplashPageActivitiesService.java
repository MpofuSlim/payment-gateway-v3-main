package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateRoleRequestDTO;
import com.example.meraki.common.createrequests.CreateSplashPageActivitiesRequestDTO;
import com.example.meraki.entities.Role;
import com.example.meraki.entities.SplashPageActivities;
import com.example.meraki.repositories.RoleRepository;
import com.example.meraki.repositories.SplashPageActivitiesRepository;
import com.example.meraki.services.response.CreateRoleResponse;
import com.example.meraki.services.response.CreateSplashPageActivitiesResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SplashPageActivitiesService {

    private SplashPageActivitiesRepository splashPageActivitiesRepository;

    public SplashPageActivitiesService(SplashPageActivitiesRepository splashPageActivitiesRepository) {
        this.splashPageActivitiesRepository = splashPageActivitiesRepository;
    }

    public SplashPageActivities getSplashPageActivities(Long id) {
        return splashPageActivitiesRepository.getReferenceById(id);
    }


    public List<SplashPageActivities> getAllSplashPageActivities() {
        return splashPageActivitiesRepository.findAll();
    }

    @Transactional
    public CreateSplashPageActivitiesResponse CreateSplashPageActivities(CreateSplashPageActivitiesRequestDTO createSplashPageActivitiesRequestDTO) {
        SplashPageActivities splashPageActivities = new SplashPageActivities(
                createSplashPageActivitiesRequestDTO.getSplashPageActivities().getDate_time()
        );

        splashPageActivitiesRepository.save(splashPageActivities);

        return new CreateSplashPageActivitiesResponse(
                splashPageActivities
        );
    }
}


