package com.project3.controllers;

import com.project3.entities.User;
import com.project3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable("id") Integer userId){

        return new User(2, "Owner name", "owner@owner.com", new Date(), new Date());
    }



    @PostMapping("/api/user/{id}")
    public User registerUser(@PathVariable("id") Integer userId){

        return new User(2, "Owner name", "owner@owner.com", new Date(), new Date());
    }

}
