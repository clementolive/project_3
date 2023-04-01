package com.project3.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Stores a response to indicate message sent successfully")
public class MessageResponse {
    String message;
}
