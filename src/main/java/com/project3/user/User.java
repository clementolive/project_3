package com.project3.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;
        String name;
        String email;
        Date created_at;
        Date updated_at;

        public User(Integer id, String name, String email, Date created_at, Date updated_at) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.created_at = created_at;
                this.updated_at = updated_at;
        }
}
