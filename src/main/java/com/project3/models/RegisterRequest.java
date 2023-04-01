package com.project3.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Register request. Credentials are email and password")
public class RegisterRequest {
    String email;
    String name;
    String password;
}
