package com.project3.controllers;
import com.project3.auth.JwtTokenUtil;
import com.project3.dtos.UserDTO;
import com.project3.entities.User;
import com.project3.models.AuthSuccess;
import com.project3.models.LoginRequest;
import com.project3.models.RegisterRequest;
import com.project3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @CrossOrigin
    @PostMapping("/api/auth/register")
    public AuthSuccess tryToRegister(@RequestBody RegisterRequest request){
        AuthSuccess authSuccess = new AuthSuccess();

        User user = userService.addNewUser(request);
        String token = jwtTokenUtil.generateToken(user);
        authSuccess.setToken(token);

        return authSuccess;
    }
    @CrossOrigin
    @PostMapping("/api/auth/login")
    public AuthSuccess tryToLogin(@RequestBody LoginRequest request){
        //Check if mail exists, correct password here

        AuthSuccess authSuccess = new AuthSuccess();
        authSuccess.setToken("jwt");
        return authSuccess;
    }

    @GetMapping("/api/auth/me")
    public UserDTO me(){
        UserDTO userDTO = new UserDTO( "test@test.com", "Test TEST");
        return userDTO;
    }

}
