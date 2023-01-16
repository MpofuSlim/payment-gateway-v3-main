package com.example.meraki.services.response;

import com.example.meraki.entities.Batch;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateBatchResponse {

    private Batch batch;

    //private Vouchers BatchId;
}
