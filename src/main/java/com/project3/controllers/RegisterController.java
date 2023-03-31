package com.project3.controllers;
import com.project3.auth.JwtTokenUtil;
import com.project3.auth.JwtUserDetailsService;
import com.project3.dtos.UserDTO;
import com.project3.entities.User;
import com.project3.mappers.UserMapper;
import com.project3.models.AuthSuccess;
import com.project3.models.LoginRequest;
import com.project3.models.RegisterRequest;
import com.project3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @Autowired // Loads user from DB
    JwtUserDetailsService userDetailsService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/api/auth/me")
    public UserDTO me(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User my_user = userDetailsService.loadUserByUsername(username);

        return userMapper.userToUserDTO(my_user);
    }

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
    public AuthSuccess tryToLogin(@RequestBody LoginRequest authenticationRequest) throws Exception {
        // Check if mail exists, correct password here
        // The link between email and internal "username" is here
        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        final UserDetails user = userDetailsService
                .loadUserByUsername(authenticationRequest.getEmail());

        if(!encoder.matches(authenticationRequest.getPassword(), user.getPassword())){
            throw new BadCredentialsException("bad credentials");
        }


        final String token = jwtTokenUtil.generateToken(user);

        AuthSuccess authSuccess = new AuthSuccess();
        authSuccess.setToken(token);
        return authSuccess;
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


}
