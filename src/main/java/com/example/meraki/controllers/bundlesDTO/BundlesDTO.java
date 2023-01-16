package com.example.meraki.controllers.bundlesDTO;


import com.example.meraki.entities.Bundles;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EntityManager;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(EntityManager.class)
@ApiModel(description = "bundles")
public class BundlesDTO {

    @ApiModelProperty(value = "Id of vouchers", example = "1")
    private Long id;

    @ApiModelProperty(value = "name of the sender.", example = "")
    private String name;

    @ApiModelProperty(value = "group policy id.", example = "")
    private String groupPolicyId;

    @ApiModelProperty(value = "bundle description", example = "")
    private String description;


    /*@ApiModelProperty(value = "bundle Date", example = "")
    private Date dateCreated;*/


    @ApiModelProperty(value = "The image", example = "")
    private String image;

    @ApiModelProperty(value = "bundle price", example = "")
    private Double price;



    public static BundlesDTO fromBundles(Bundles bundles) {
        return new BundlesDTO(bundles.getId(), bundles.getName(), bundles.getGroupPolicyId(), bundles.getDescription(),
                bundles.getImage(), bundles.getPrice());

    }

}
