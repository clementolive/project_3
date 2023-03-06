package com.project3.auth;

import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @GetMapping("/")
    public String hello(){
        //System.out.println("hello");
        return "hello";
    }

    @GetMapping("/auth/register")
    public AuthSuccess troToRegister(){
        AuthSuccess authSuccess = new AuthSuccess();
        authSuccess.token = "jwt";
        //System.out.println("hello");
        return authSuccess;
    }
}
