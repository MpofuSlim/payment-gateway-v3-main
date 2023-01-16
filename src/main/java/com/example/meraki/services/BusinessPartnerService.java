package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateBusinessPartnerRequestDTO;
import com.example.meraki.common.createrequests.CreateRoleRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBusinessPartnerRequestDTO;
import com.example.meraki.entities.BusinessPartner;
import com.example.meraki.entities.Role;
import com.example.meraki.repositories.BusinessPartnerRepository;
import com.example.meraki.repositories.RoleRepository;
import com.example.meraki.services.response.CreateBusinessPartnerResponse;
import com.example.meraki.services.response.CreateRoleResponse;
import com.example.meraki.services.response.UpdateBusinessPartnerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusinessPartnerService {
    @Autowired
    private BusinessPartnerRepository businessPartnerRepository;

    public BusinessPartnerService(BusinessPartnerRepository businessPartnerRepository) {
        this.businessPartnerRepository = businessPartnerRepository;
    }

    public BusinessPartner getBusinessPartner(Long id) {
        return businessPartnerRepository.getReferenceById(id);
    }


    public List<BusinessPartner> getAllBusinessPartrners() {
        return businessPartnerRepository.findAll();
    }


    @Transactional
    public CreateBusinessPartnerResponse CreateBusinessPartner(CreateBusinessPartnerRequestDTO createBusinessPartnerRequestDTO) {
        BusinessPartner businessPartner = new BusinessPartner(
                createBusinessPartnerRequestDTO.getBusinessPartner().getName(),
                createBusinessPartnerRequestDTO.getBusinessPartner().getBusinessAddress(),
                createBusinessPartnerRequestDTO.getBusinessPartner().getEmail(),
                createBusinessPartnerRequestDTO.getBusinessPartner().getPhoneNumber(),
                false
        );

        businessPartnerRepository.save(businessPartner);

        return new CreateBusinessPartnerResponse(
                businessPartner
        );
    }

    public UpdateBusinessPartnerResponse updateBusinessPartner(UpdateBusinessPartnerRequestDTO updateBusinessPartnerRequestDTO) {

        BusinessPartner businessPartner = businessPartnerRepository.getReferenceById(updateBusinessPartnerRequestDTO.getId());
        businessPartner.setName(updateBusinessPartnerRequestDTO.getName());
        businessPartner.setBusinessAddress(updateBusinessPartnerRequestDTO.getBusinessAddress());
        businessPartner.setEmail(updateBusinessPartnerRequestDTO.getEmail());
        businessPartner.setPhoneNumber(updateBusinessPartnerRequestDTO.getPhoneNumber());
        businessPartner.setActive(updateBusinessPartnerRequestDTO.getActive());

        businessPartnerRepository.save(businessPartner);

        UpdateBusinessPartnerResponse updateBusinessPartnerResponse = new UpdateBusinessPartnerResponse(
                businessPartner.getName(),
                businessPartner.getBusinessAddress(),
                businessPartner.getEmail(),
                businessPartner.getPhoneNumber(),
                businessPartner.getActive()
        );

        return  updateBusinessPartnerResponse;
    }

}
