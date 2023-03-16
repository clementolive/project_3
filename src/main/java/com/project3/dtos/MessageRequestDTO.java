package com.project3.dtos;

import lombok.Data;

@Data
public class MessageRequestDTO {
    Integer rental_id;
    Integer user_id;
    String message;
}
