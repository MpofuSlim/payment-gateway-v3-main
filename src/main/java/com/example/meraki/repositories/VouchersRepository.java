package com.example.meraki.repositories;

import com.example.meraki.entities.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VouchersRepository extends BaseRepository<Vouchers> {

    Vouchers findByVoucherCode(String code);

    List<Vouchers> findByOrder(Order order);

    Vouchers findByUsed(Boolean used);

    List<Vouchers> findBySold(Boolean sold);

    List<Vouchers> findByBatch(Batch batch);

    List<Vouchers> findByBundle(Bundles bundles);

    List<Vouchers> findByBundleAndSold(Bundles bundles, Boolean sold);

    Boolean existsByVoucherCode(String voucherCode);


}
