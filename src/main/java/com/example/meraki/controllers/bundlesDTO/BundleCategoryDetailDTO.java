package com.example.meraki.controllers.bundlesDTO;

import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "BundleCategory detailed info")
public class BundleCategoryDetailDTO {

    private BundleCategoryDTO  bundleCategory;

    private UserDTO user;
}
