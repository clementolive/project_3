package com.project3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;
        String name;
        String email;
        Date created_at;
        Date updated_at;

        public User(String name, String email) {
                this.name = name;
                this.email = email;
                this.created_at = new Date();
                this.updated_at = new Date();
        }
}
