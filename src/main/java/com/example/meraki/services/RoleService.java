package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateRoleRequestDTO;
import com.example.meraki.common.createrequests.CreateUserRequestDTO;
import com.example.meraki.common.updaterequests.UpdateRoleRequestDTO;
import com.example.meraki.entities.Networks;
import com.example.meraki.entities.Role;
import com.example.meraki.entities.User;
import com.example.meraki.repositories.RoleRepository;
import com.example.meraki.repositories.UserRepository;
import com.example.meraki.services.response.CreateRoleResponse;
import com.example.meraki.services.response.CreateUserResponse;
import com.example.meraki.services.response.UpdateRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRole(Long id) {
        return roleRepository.getReferenceById(id);
    }


    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    @Transactional
    public CreateRoleResponse CreateRole(CreateRoleRequestDTO createRoleRequestDTO) {
        Role role = new Role(
                createRoleRequestDTO.getRole().getRole(),
                false
        );

        roleRepository.save(role);

        return new CreateRoleResponse(
                role
        );
    }


    public UpdateRoleResponse updateRole(UpdateRoleRequestDTO updateRoleRequestDTO) {

        Role role = roleRepository.getReferenceById(updateRoleRequestDTO.getId());
        role.setRole(updateRoleRequestDTO.getRole());
        role.setActive(updateRoleRequestDTO.getActive());

        roleRepository.save(role);

        UpdateRoleResponse updateRoleResponse = new UpdateRoleResponse(
                role.getRole(),
                role.getActive()
        );

        return  updateRoleResponse;
    }
}
