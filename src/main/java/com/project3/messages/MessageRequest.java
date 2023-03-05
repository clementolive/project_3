package com.project3.messages;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MessageRequest {
    Integer rental_id;
    Integer user_id;
    String message;
}
