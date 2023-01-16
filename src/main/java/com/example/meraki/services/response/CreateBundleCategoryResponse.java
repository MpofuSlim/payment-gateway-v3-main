
package com.example.meraki.services.response;

import com.example.meraki.entities.BundleCategory;
import com.example.meraki.entities.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateBundleCategoryResponse {
    private BundleCategory bundleCategory;
    private User user;
}


