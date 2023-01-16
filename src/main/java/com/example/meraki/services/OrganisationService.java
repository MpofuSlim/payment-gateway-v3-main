package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateCustomerRequestDTO;
import com.example.meraki.common.createrequests.CreateOrganisationRequestDTO;
import com.example.meraki.common.updaterequests.UpdateOrganisationsRequestDTO;
import com.example.meraki.entities.*;
import com.example.meraki.repositories.BundlesRepository;
import com.example.meraki.repositories.CustomersRepository;
import com.example.meraki.repositories.OrganisationsRepository;
import com.example.meraki.repositories.UserRepository;
import com.example.meraki.services.response.CreateCustomerResponse;
import com.example.meraki.services.response.CreateOrganisationResponse;
import com.example.meraki.services.response.UpdateOrganisationsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class OrganisationService {
    @Autowired
    private OrganisationsRepository organisationsRepository;
    @Autowired
    private UserRepository userRepository;

    public OrganisationService(OrganisationsRepository organisationsRepository){
        this.organisationsRepository = organisationsRepository;
    }

    public Organisations getOrganisation(Long id) {
        return organisationsRepository.getReferenceById(id);
    }

    public List<Organisations> getAllOrganisations() {
        return organisationsRepository.findAll();
    }

    public CreateOrganisationResponse createOrganisation(CreateOrganisationRequestDTO createOrganisationRequestDTO) throws IOException {
        User user1 = userRepository.getReferenceById(createOrganisationRequestDTO.getUserID());
        Organisations organisations = new Organisations(
                user1,
                createOrganisationRequestDTO.getOrganisation().getName(),
                createOrganisationRequestDTO.getOrganisation().getDate_created(),
                false
        );

        organisationsRepository.save(organisations);

        return new CreateOrganisationResponse(
                organisations,
                user1
        );
    }

    public UpdateOrganisationsResponse updateOrganisations(UpdateOrganisationsRequestDTO updateOrganisationsRequestDTO) {

        Organisations organisations = organisationsRepository.getReferenceById(updateOrganisationsRequestDTO.getId());
        organisations.setName(updateOrganisationsRequestDTO.getName());
        organisations.setActive(updateOrganisationsRequestDTO.getActive());

        organisationsRepository.save(organisations);

        UpdateOrganisationsResponse updateOrganisationsResponse = new UpdateOrganisationsResponse(
                organisations.getName(),
                organisations.getActive()
        );

        return  updateOrganisationsResponse;
    }
}
