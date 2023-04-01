package com.project3.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Login Request with email and password as credentials")
public class LoginRequest {
    String email;
    String password;
}
