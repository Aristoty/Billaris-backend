package com.company.billaris2.services.interfaces;

import com.company.billaris2.DTO.UserDTO;
import com.company.billaris2.entities.User;
import com.company.billaris2.models.JwtResponse;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;

@Component
public interface UserService {


    User createUser(UserDTO userDTO);

    User getUserById(Integer id);

    List<User> getAllUsers();

    User updateUser(Integer id, UserDTO userDTO);

    void deleteUser(Integer id);



    JwtResponse getCurrentUser(Principal principal);
}
