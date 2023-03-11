package com.project3.controllers;

import com.project3.entities.MessageResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @PostMapping("/api/messages")
    public MessageResponse send(){
        //Send message here (service -> repo -> DB)

        //Response
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Message send with success");
        return messageResponse;
    }
}
