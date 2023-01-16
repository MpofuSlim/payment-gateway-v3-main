package com.example.meraki.repositories;

import com.example.meraki.entities.BundleCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface BundlesCategoryRepository extends BaseRepository<BundleCategory> {

    BundleCategory findByDuration(Integer duration);
}
