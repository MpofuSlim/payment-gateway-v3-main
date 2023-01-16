package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateAdminPortalUsersRequestDTO;
import com.example.meraki.common.createrequests.CreateAdminPortalUsersRolesRequestDTO;
import com.example.meraki.common.updaterequests.UpdateAdminPortalUsersRequestDTO;
import com.example.meraki.common.updaterequests.UpdateAdminPortalUsersRolesRequestDTO;
import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.AdminPortalUsersRoles;
import com.example.meraki.entities.Role;
import com.example.meraki.entities.User;
import com.example.meraki.repositories.AdminPortalUsersRepository;
import com.example.meraki.repositories.AdminPortalUsersRolesRepository;
import com.example.meraki.repositories.RoleRepository;
import com.example.meraki.repositories.UserRepository;
import com.example.meraki.services.response.CreateAdminPortalUsersResponse;
import com.example.meraki.services.response.CreateAdminPortalUsersRolesResponse;
import com.example.meraki.services.response.UpdateAdminPortalUsersResponse;
import com.example.meraki.services.response.UpdateAdminPortalUsersRolesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AdminPortalUsersRolesService {

    @Autowired
    private AdminPortalUsersRolesRepository adminPortalUsersRoleRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public AdminPortalUsersRolesService(AdminPortalUsersRolesRepository adminPortalUsersRoleRepository) {
        this.adminPortalUsersRoleRepository = adminPortalUsersRoleRepository;
    }

    public List<AdminPortalUsersRoles> getAllAdminPortalUsersRoles(){
        return adminPortalUsersRoleRepository.findAll();
    }
    //public List<Vouchers> getAllVouchers() {
    //return vouchersRepository.findAll();
    //}



    //public List<Vouchers> getVoucherByCategoryId(Integer id) {
    // return vouchersRepository.findByCategoryId(id);
    //}

    public CreateAdminPortalUsersRolesResponse createAdminPortalUsersRoles(CreateAdminPortalUsersRolesRequestDTO createAdminPortalUsersRolesRequestDTO) throws IOException {
        User user1 = userRepository.getReferenceById(createAdminPortalUsersRolesRequestDTO.getUserID());
        //Role role1 = roleRepository.getReferenceById(createAdminPortalUsersRolesRequestDTO.getRoleID());
        AdminPortalUsersRoles adminPortalUsersRoles = new AdminPortalUsersRoles(
                user1,
                createAdminPortalUsersRolesRequestDTO.getAdminPortalUsersRolesDTO().getName(),
                createAdminPortalUsersRolesRequestDTO.getAdminPortalUsersRolesDTO().getDate_created(),
                false
        );

        adminPortalUsersRoleRepository.save(adminPortalUsersRoles);

        return new CreateAdminPortalUsersRolesResponse(
                adminPortalUsersRoles,
                user1
        );
    }

    public UpdateAdminPortalUsersRolesResponse updateAdminPortalUsersRoles(UpdateAdminPortalUsersRolesRequestDTO updateAdminPortalUsersRolesRequestDTO) {

        AdminPortalUsersRoles adminPortalUsersRoles = adminPortalUsersRoleRepository.getReferenceById(updateAdminPortalUsersRolesRequestDTO.getId());
        adminPortalUsersRoles.setName(updateAdminPortalUsersRolesRequestDTO.getName());
        adminPortalUsersRoles.setDate_created(updateAdminPortalUsersRolesRequestDTO.getDate_created());
        adminPortalUsersRoles.setActive(updateAdminPortalUsersRolesRequestDTO.getActive());

        adminPortalUsersRoleRepository.save(adminPortalUsersRoles);

        UpdateAdminPortalUsersRolesResponse updateAdminPortalUsersRolesResponse = new UpdateAdminPortalUsersRolesResponse(
                adminPortalUsersRoles.getName(),
                adminPortalUsersRoles.getDate_created(),
                adminPortalUsersRoles.getActive()
        );

        return  updateAdminPortalUsersRolesResponse;
    }
}
