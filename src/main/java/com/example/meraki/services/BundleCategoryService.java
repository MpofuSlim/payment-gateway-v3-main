package com.example.meraki.services;


import com.example.meraki.common.createrequests.CreateBundleCategoryRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBundleCategoryRequestDTO;
import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.BundleCategory;
import com.example.meraki.entities.User;
import com.example.meraki.repositories.BundlesCategoryRepository;
import com.example.meraki.repositories.UserRepository;
import com.example.meraki.services.response.CreateBundleCategoryResponse;
import com.example.meraki.services.response.UpdateBundleCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;


@Service
public class BundleCategoryService {

    @Autowired
    private BundlesCategoryRepository bundlesCategoryRepository;

    @Autowired
    private UserRepository userRepository;

    public BundleCategoryService(BundlesCategoryRepository bundlesCategoryRepository) {
        this.bundlesCategoryRepository = bundlesCategoryRepository;
    }

    public BundleCategory getBundlesCategory(Long id) {
        return bundlesCategoryRepository.getReferenceById(id);
    }

    public List<BundleCategory> getAllBundleCategory(){
        return bundlesCategoryRepository.findAll();
    }
    @Transactional
    public CreateBundleCategoryResponse createBundleCategory(CreateBundleCategoryRequestDTO categoryRequestDTO) throws IOException {
        User user1 = userRepository.getReferenceById(categoryRequestDTO.getUserID());
        BundleCategory bundleCategory=new BundleCategory(
                user1,
                categoryRequestDTO.getBundleCategory().getName(),
                categoryRequestDTO.getBundleCategory().getDescription(),
                categoryRequestDTO.getBundleCategory().getDuration(),
                categoryRequestDTO.getBundleCategory().getDateCreated(),
                false

        );

        bundlesCategoryRepository.save(bundleCategory);

        return new CreateBundleCategoryResponse(
                bundleCategory,
                user1
        );
    }

    public UpdateBundleCategoryResponse updateBundleCategory(UpdateBundleCategoryRequestDTO updateBundleCategoryRequestDTO) {

        BundleCategory bundleCategory = bundlesCategoryRepository.getReferenceById(updateBundleCategoryRequestDTO.getId());
        bundleCategory.setName(updateBundleCategoryRequestDTO.getName());
        bundleCategory.setDescription(updateBundleCategoryRequestDTO.getDescription());
        bundleCategory.setActive(updateBundleCategoryRequestDTO.getActive());

        bundlesCategoryRepository.save(bundleCategory);

        UpdateBundleCategoryResponse updateBundleCategoryResponse = new UpdateBundleCategoryResponse(
                bundleCategory.getName(),
                bundleCategory.getDescription(),
                bundleCategory.getActive()
        );

        return  updateBundleCategoryResponse;
    }

}
