package com.project3.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String email;
    String name;
    Date created_at;
    Date updated_at;

    public UserDTO(String email, String name) {
        this.email = email;
        this.name = name;
        this.created_at = new Date();
        this.updated_at = new Date();
    }
}
