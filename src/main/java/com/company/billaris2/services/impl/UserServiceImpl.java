package com.company.billaris2.services.impl;

import com.company.billaris2.DTO.UserDTO;
import com.company.billaris2.entities.User;
import com.company.billaris2.models.JwtResponse;
import com.company.billaris2.repositories.UserRepository;
import com.company.billaris2.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Integer id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            modelMapper.map(userDTO, existingUser);
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public JwtResponse getCurrentUser(Principal principal){

        Optional<User> user = userRepository.findByEmail(principal.getName());

        return JwtResponse.builder()
                .id(user.get().getId())
                .username(user.get().getUsername())
                .build();
    }
}