package com.project3.services;

import com.project3.entities.User;
import com.project3.repositories.UserRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addNewStudent(User user) {
        userRepository.save(user);
    }

}


