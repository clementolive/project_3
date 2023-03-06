package com.project3.messages;

import com.project3.auth.AuthSuccess;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @PostMapping("/api/messages")
    public MessageResponse send(){
        //Send message here (service -> repo -> DB)

        //Response
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.message = "Message send with success";
        return messageResponse;
    }
}
