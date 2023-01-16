package com.example.meraki.repositories;


import com.example.meraki.entities.BundleCategory;
import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BundlesRepository extends BaseRepository<Bundles>{

    List<Bundles> findByid(Long id);

    Bundles findByGroupPolicyId(String groupPolicyId);

    List<Bundles> findByBundleCategory(BundleCategory bundleCategory);

    List<Bundles> findByActive(Boolean active);

}
