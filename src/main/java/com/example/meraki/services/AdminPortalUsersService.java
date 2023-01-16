package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateAdminPortalUsersRequestDTO;
import com.example.meraki.common.createrequests.CreateVoucherRequestDTO;
import com.example.meraki.common.misc.AdminLoginRequestDTO;
import com.example.meraki.common.misc.UserLoginRequestDTO;
import com.example.meraki.common.updaterequests.UpdateAdminPortalUsersRequestDTO;
import com.example.meraki.entities.*;
import com.example.meraki.repositories.*;
import com.example.meraki.services.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AdminPortalUsersService {

    @Autowired
    private AdminPortalUsersRepository adminPortalUsersRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public AdminPortalUsersService(AdminPortalUsersRepository adminPortalUsersRepository) {
        this.adminPortalUsersRepository = adminPortalUsersRepository;
    }

    public AdminPortalUsers getAdminPortalUser(Long id) {
        return adminPortalUsersRepository.getReferenceById(id);
    }

    public List<AdminPortalUsers> getAllAdminPortalUsers(){
        return adminPortalUsersRepository.findAll();
    }


    public CreateAdminPortalUsersResponse createAdminPortalUsers(CreateAdminPortalUsersRequestDTO createAdminPortalUsersRequestDTO) throws IOException {

        Role role1 = roleRepository.getReferenceById(createAdminPortalUsersRequestDTO.getRoleID());
        AdminPortalUsers adminPortalUsers = new AdminPortalUsers(

                role1,
                createAdminPortalUsersRequestDTO.getAdminPortalUsersDTO().getFirstname(),
                createAdminPortalUsersRequestDTO.getAdminPortalUsersDTO().getSurname(),
                createAdminPortalUsersRequestDTO.getAdminPortalUsersDTO().getEmail_address(),
                createAdminPortalUsersRequestDTO.getAdminPortalUsersDTO().getPassword(),

                false
        );

        adminPortalUsersRepository.save(adminPortalUsers);

        return new CreateAdminPortalUsersResponse(
                adminPortalUsers,

                role1
        );
    }

    public UpdateAdminPortalUsersResponse updateAdminPortalUsers(UpdateAdminPortalUsersRequestDTO updateAdminPortalUsersRequestDTO) {

        AdminPortalUsers adminPortalUsers = adminPortalUsersRepository.getReferenceById(updateAdminPortalUsersRequestDTO.getId());
        adminPortalUsers.setFirstname(updateAdminPortalUsersRequestDTO.getFirstname());
        adminPortalUsers.setSurname(updateAdminPortalUsersRequestDTO.getSurname());
        adminPortalUsers.setEmailAddress(updateAdminPortalUsersRequestDTO.getEmailAddress());

        adminPortalUsersRepository.save(adminPortalUsers);

        UpdateAdminPortalUsersResponse updateAdminPortalUsersResponse = new UpdateAdminPortalUsersResponse(
                adminPortalUsers.getFirstname(),
                adminPortalUsers.getSurname(),
                adminPortalUsers.getEmailAddress(),
                adminPortalUsers.getActive()
        );

        return  updateAdminPortalUsersResponse;
    }


    public boolean checkAdminExists(AdminLoginRequestDTO adminLoginRequestDTO) {
        AdminPortalUsers admin = adminPortalUsersRepository.findByEmailAddressAndPassword(adminLoginRequestDTO.getEmailAddress(), adminLoginRequestDTO.getPassword());

        if (admin == null) {
            return false;
        } else {
            return true;
        }
    }

    public AdminLoginResponse loginResponse(AdminLoginRequestDTO adminLoginRequestDTO) {
        AdminPortalUsers admin = adminPortalUsersRepository.findByEmailAddressAndPassword(adminLoginRequestDTO.getEmailAddress(), adminLoginRequestDTO.getPassword());
        return new AdminLoginResponse(
                admin.getFirstname(),
                admin.getSurname(),
                admin.getEmailAddress(),
                admin.getRole()
        );
    }

}
