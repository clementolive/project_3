package com.project3.messages;

import lombok.Data;

@Data
public class MessageRequest {
    Integer rental_id;
    Integer user_id;
    String message;
}
