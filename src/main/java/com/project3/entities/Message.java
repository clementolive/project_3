package com.project3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer rental_id;
    Integer user_id;
    String message;
    Date created_at;
    Date updated_at;

    public Message(String message, Integer rental_id, Integer user_id) {
        this.message = message;
        this.rental_id = rental_id;
        this.user_id = user_id;
        this.created_at = new Date();
        this.updated_at = new Date();
    }

}
