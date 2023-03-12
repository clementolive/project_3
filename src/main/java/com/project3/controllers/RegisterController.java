package com.project3.controllers;

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

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @PostMapping("/api/auth/register")
    public AuthSuccess tryToRegister(@RequestBody RegisterRequest request){
        AuthSuccess authSuccess = new AuthSuccess();
        authSuccess.setToken("jwt");

        User user = new User(request.getName(), request.getEmail());
        userService.addNewStudent(user);
        return authSuccess;
    }

    @PostMapping("/api/auth/login")
    public AuthSuccess tryToLogin(){
        AuthSuccess authSuccess = new AuthSuccess();
        authSuccess.setToken("jwt");
        return authSuccess;
    }

    @GetMapping("/api/auth/me")
    public User me(){
        User user = new User(1, "Test TEST", "test@test.com", new Date(), new Date());
        return user;
    }
}
