package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateSplashPageActivitiesRequestDTO;
import com.example.meraki.common.createrequests.CreateSplashPageConnectionsRequestDTO;
import com.example.meraki.common.updaterequests.UpdateSplashPageConnectionsRequestDTO;
import com.example.meraki.entities.*;
import com.example.meraki.repositories.CustomersRepository;
import com.example.meraki.repositories.SplashPageActivitiesRepository;
import com.example.meraki.repositories.SplashPageConnectionsRepository;
import com.example.meraki.repositories.VouchersRepository;
import com.example.meraki.services.response.CreateSplashPageActivitiesResponse;
import com.example.meraki.services.response.CreateSplashPageConnectionsResponse;
import com.example.meraki.services.response.UpdateSplashPageConnectionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class SplashPageConnectionsService {

    @Autowired
    private SplashPageConnectionsRepository splashPageConnectionsRepository;

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private VouchersRepository voucherRepository;

    public SplashPageConnectionsService(SplashPageConnectionsRepository splashPageConnectionsRepository) {
        this.splashPageConnectionsRepository = splashPageConnectionsRepository;
    }

    public SplashPageConnections getSplashPageConnections(Long id) {
        return splashPageConnectionsRepository.getReferenceById(id);
    }


    public List<SplashPageConnections> getAllSplashPageConnections() {
        return splashPageConnectionsRepository.findAll();
    }

    @Transactional
    public CreateSplashPageConnectionsResponse CreateSplashPageConnections(CreateSplashPageConnectionsRequestDTO createSplashPageConnectionsRequestDTO) throws IOException {
        Customers customers1 = customersRepository.getReferenceById(createSplashPageConnectionsRequestDTO.getCustomerID());
        Vouchers vouchers1 = voucherRepository.getReferenceById(createSplashPageConnectionsRequestDTO.getVoucherID());

        SplashPageConnections splashPageConnections = new SplashPageConnections(
                customers1,
                vouchers1,
                createSplashPageConnectionsRequestDTO.getSplashPageConnections().getConnection_time(),
                createSplashPageConnectionsRequestDTO.getSplashPageConnections().getLocation(),
                false
                );

        splashPageConnectionsRepository.save(splashPageConnections);

        return new CreateSplashPageConnectionsResponse(
                splashPageConnections,
                customers1,
                vouchers1
        );
    }

    public UpdateSplashPageConnectionsResponse updateSplashPageConnections(UpdateSplashPageConnectionsRequestDTO updateSplashPageConnectionsRequestDTO) {
        SplashPageConnections splashPageConnections = splashPageConnectionsRepository.getReferenceById(updateSplashPageConnectionsRequestDTO.getId());
        splashPageConnections.setLocation(updateSplashPageConnectionsRequestDTO.getLocation());
        splashPageConnections.setIsConnected(updateSplashPageConnectionsRequestDTO.getIsConnected());

        splashPageConnectionsRepository.save(splashPageConnections);

        UpdateSplashPageConnectionsResponse updateSplashPageConnectionsResponse = new UpdateSplashPageConnectionsResponse(
                splashPageConnections.getLocation(),
                splashPageConnections.getIsConnected()
        );

        return updateSplashPageConnectionsResponse;
    }
}
