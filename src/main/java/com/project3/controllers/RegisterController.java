package com.project3.controllers;

import com.project3.dtos.UserDTO;
import com.project3.mappers.UserMapper;
import com.project3.models.AuthSuccess;
import com.project3.entities.User;
import com.project3.models.RegisterRequest;
import com.project3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping("/api/auth/register")
    public AuthSuccess tryToRegister(@RequestBody RegisterRequest request){
        // Check if used name/email here

        AuthSuccess authSuccess = new AuthSuccess();
        authSuccess.setToken("jwt");

        UserDTO user = new UserDTO(request.getName(), request.getEmail());
        userService.addNewUser(user);
        return authSuccess;
    }

    @PostMapping("/api/auth/login")
    public AuthSuccess tryToLogin(){
        //Check if mail exists, correct password here

        AuthSuccess authSuccess = new AuthSuccess();
        authSuccess.setToken("jwt");
        return authSuccess;
    }

    @GetMapping("/api/auth/me")
    public UserDTO me(){
        UserDTO userDTO = new UserDTO("Test TEST", "test@test.com");
        return userDTO;
    }
}
