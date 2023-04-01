package com.project3.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Stores the JWT token")
public class AuthSuccess {
    String token;
}
