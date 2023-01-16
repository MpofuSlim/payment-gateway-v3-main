package com.example.meraki.controllers.BatchDTO;

import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.entities.Batch;
import com.example.meraki.entities.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "bundle")
public class BatchDTO {

    @ApiModelProperty(value = "", example = "")
    private String batchName;


    public static BatchDTO fromBatch(Batch batch) {

        return new BatchDTO(batch.getBatchName());
    }

}
