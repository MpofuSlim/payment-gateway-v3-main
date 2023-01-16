package com.example.meraki.repositories;

import com.example.meraki.entities.Batch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends BaseRepository<Batch> {

      List<Batch>  findById(long id);
      List<Batch> findByActive(Boolean active);

}
