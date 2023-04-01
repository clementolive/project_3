package com.project3.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Indicates rental created/updated successfully")
public class RentalResponse {
    String message;
}
