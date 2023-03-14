package com.project3.controllers;

import com.project3.dtos.UserDTO;
import com.project3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/api/user/{id}")
    public UserDTO getUser(@PathVariable("id") Long userId){

        return userService.getUserById(userId);
    }
}
