package com.project3.models;

import lombok.Data;

@Data
public class RegisterRequest {
    String email;
    String name;
    String password;
}
