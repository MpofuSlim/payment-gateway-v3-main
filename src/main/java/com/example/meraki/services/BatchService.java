package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateBatchRequestDTO;
import com.example.meraki.common.createrequests.CreateSellBatchRequestDTO;
import com.example.meraki.common.updaterequests.UpdateAdminPortalUsersRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBatchRequestDTO;
import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.Batch;
import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.Vouchers;
import com.example.meraki.repositories.BatchRepository;
import com.example.meraki.repositories.VouchersRepository;
import com.example.meraki.services.response.CreateBatchResponse;
import com.example.meraki.services.response.CreateSellBatchResponse;
import com.example.meraki.services.response.UpdateAdminPortalUsersResponse;
import com.example.meraki.services.response.UpdateBatchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class BatchService {

    @Autowired
    private  BatchRepository batchRepository;

    @Autowired
    private VouchersRepository vouchersRepository;

    public List<Batch> getBatchById(long id){
        return batchRepository.findById(id);
    }

    public List<Batch> getAllBatches(){
        return batchRepository.findAll();
    }


    public List<Batch> getBatchByActive(Boolean active) {
        return batchRepository.findByActive(active);
    }

    public Batch getBatch(Long id) {
        return batchRepository.getReferenceById(id);
    }

    public CreateBatchResponse createBatchId(CreateBatchRequestDTO createBatchRequestDTO) {
        //Vouchers voucherId1 = vouchersRepository.getReferenceById(createBatchRequestDTO.getVoucherID());
        Batch batch=new Batch(
                 //voucherId1,
                 //createBatchRequestDTO.getBatch().getBatchId(),
                 createBatchRequestDTO.getBatch().getBatchName(),
                false
        );
        batchRepository.save(batch);
        return new CreateBatchResponse(
                batch
                //batchId1
        );

    }


    /*code below for voucher get batch*/
     public CreateSellBatchResponse createBatch(CreateSellBatchRequestDTO createSellBatchRequestDTO){
        //Vouchers voucherId1 = vouchersRepository.getReferenceById(createSellBatchRequestDTO.getVoucherID());
        Batch batch=new Batch(
                //voucherId1,#
                //createSellBatchRequestDTO.getBatch().getBatchId(),
                createSellBatchRequestDTO.getBatch().getBatchName(),
                false
        );

        batchRepository.save(batch);
        return new CreateSellBatchResponse(
                batch.getId(),
                //batch.getBatchId(),
                //batch.getBatchName(),
                batch.getActive()
        );

    }

    public UpdateBatchResponse updateBatch(UpdateBatchRequestDTO updateBatchRequestDTO) {

        Batch batch = batchRepository.getReferenceById(updateBatchRequestDTO.getId());
        batch.setBatchName(updateBatchRequestDTO.getBatchName());
        batch.setActive(updateBatchRequestDTO.getActive());

        batchRepository.save(batch);

        UpdateBatchResponse updateBatchResponse = new UpdateBatchResponse(
                batch.getBatchName(),
                batch.getActive()
        );

        return  updateBatchResponse;
    }


}
