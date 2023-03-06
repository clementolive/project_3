package com.project3.auth;

import com.project3.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class RegisterController {

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @PostMapping("/api/auth/register")
    public AuthSuccess tryToRegister(){
        AuthSuccess authSuccess = new AuthSuccess();
        authSuccess.token = "jwt";
        return authSuccess;
    }

    @PostMapping("/api/auth/login")
    public AuthSuccess tryToLogin(){
        AuthSuccess authSuccess = new AuthSuccess();
        authSuccess.token = "jwt";
        return authSuccess;
    }

    @GetMapping("/api/auth/me")
    public User me(){
        User user = new User(2, "Anthony", "ant@gmail.com", new Date(), new Date());
        return user;
    }
}
