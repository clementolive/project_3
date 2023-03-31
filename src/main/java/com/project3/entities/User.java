package com.project3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;
        String email;
        String name;
        String password;
        Date created_at;
        Date updated_at;

        public User(String email, String name, String password) {
                this.email = email;
                this.name = name;
                this.password = password;
                this.created_at = new Date();
                this.updated_at = new Date();
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
        }

        @Override
        public String getUsername() {
                return this.email;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }
}
