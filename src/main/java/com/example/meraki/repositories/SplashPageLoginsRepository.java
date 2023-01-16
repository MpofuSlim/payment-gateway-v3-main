package com.example.meraki.repositories;

import com.example.meraki.entities.Batch;
import com.example.meraki.entities.SplashPageLogins;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SplashPageLoginsRepository extends BaseRepository<SplashPageLogins> {

    List<SplashPageLogins> findById(long id);
}
