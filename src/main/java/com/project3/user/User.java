package com.project3.user;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
        Integer id;
        String name;
        String email;
        Date created_at;
        Date updated_at;
}
