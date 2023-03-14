package com.project3.controllers;

import com.project3.dtos.UserDTO;
import com.project3.models.AuthSuccess;
import com.project3.models.RegisterRequest;
import com.project3.services.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping("/api/auth/register")
    public AuthSuccess tryToRegister(@RequestBody RegisterRequest request){
        AuthSuccess authSuccess = new AuthSuccess();
        // Check if used name/email here
        if (!userService.existByName(request.getName()) &&
                !userService.existsByEmail(request.getEmail())) {

            authSuccess.setToken("jwt");
            userService.addNewUser(request);
        } else{
            authSuccess.setToken("username/email taken");
        }


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
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDTO userDTO = new UserDTO("Test TEST", "test@test.com");
        return userDTO;
    }
}
