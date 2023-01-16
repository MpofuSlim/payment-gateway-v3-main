package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateUserRequestDTO;
import com.example.meraki.common.misc.UserLoginRequestDTO;
import com.example.meraki.entities.Role;
import com.example.meraki.entities.User;
import com.example.meraki.repositories.UserRepository;
import com.example.meraki.services.response.CreateUserResponse;
import com.example.meraki.services.response.UserLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        return userRepository.getReferenceById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public CreateUserResponse CreateUser(CreateUserRequestDTO createUserRequestDTO) {
        User user = new User(
                createUserRequestDTO.getUser().getEmail(),
                createUserRequestDTO.getUser().getPhoneNumber(),
                createUserRequestDTO.getUser().getFirstname(),
                createUserRequestDTO.getUser().getSurname(),
                createUserRequestDTO.getUser().getPassword(),
                false
        );

        userRepository.save(user);

        return new CreateUserResponse(
                user
        );


    }

    public boolean checkUserExists(UserLoginRequestDTO userLoginRequestDTO) {
        User user = userRepository.findByEmailAndPassword(userLoginRequestDTO.getEmail(), userLoginRequestDTO.getPassword());

        if (user == null) {
            return false;
        } else {
            return true;
        }
    }


    public UserLoginResponse loginResponse(UserLoginRequestDTO userLoginRequestDTO) {
        User user = userRepository.findByEmailAndPassword(userLoginRequestDTO.getEmail(), userLoginRequestDTO.getPassword());
        return new UserLoginResponse(
                user.getFirstname(),
                user.getSurname()
        );
    }
}
