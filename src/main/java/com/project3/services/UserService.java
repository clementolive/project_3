package com.project3.services;

import com.project3.dtos.UserDTO;
import com.project3.entities.User;
import com.project3.mappers.UserMapper;
import com.project3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    public void addNewUser(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        userRepository.save(user);
    }

}


