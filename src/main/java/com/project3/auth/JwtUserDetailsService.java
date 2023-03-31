package com.project3.auth;

import com.project3.entities.User;
import com.project3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        com.project3.entities.User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }else{
            return user;
        }
    }

}