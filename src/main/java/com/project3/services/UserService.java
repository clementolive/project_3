package com.project3.services;

import com.project3.dtos.UserDTO;
import com.project3.entities.User;
import com.project3.mappers.UserMapper;
import com.project3.models.RegisterRequest;
import com.project3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    public void addNewUser(RegisterRequest request) {
        User user = new User(request.getEmail(), request.getName(), request.getPassword());
        userRepository.save(user);
    }

    public UserDTO getUserById(Long id){
        User user = userRepository.findById(id).orElse(new User());
        UserDTO userDTO = userMapper.userToUserDTO(user);
        return userDTO;
    }

    public boolean existByName(String name) {
        return userRepository.existsByname(name);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}


