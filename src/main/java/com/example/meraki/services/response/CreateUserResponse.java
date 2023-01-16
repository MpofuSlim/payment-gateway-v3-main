
package com.example.meraki.services.response;

import com.example.meraki.controllers.RoleDTO.RoleDetailDTO;
import com.example.meraki.entities.User;
import io.swagger.annotations.ApiModel;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "user payload")
public class CreateUserResponse {
    private User user;


}


