package com.project3.controllers;

import com.project3.dtos.UserDTO;
import com.project3.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Operation(summary = "Get a user's info", description = "This get detailed information on a user from its ID.", tags = "Get")
    @GetMapping("/api/user/{id}")
    public UserDTO getUser(@Parameter(description = "A user's ID") @PathVariable("id") Long userId){

        return userService.getUserById(userId);
    }
}
