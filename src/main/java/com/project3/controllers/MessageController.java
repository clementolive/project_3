package com.project3.controllers;

import com.project3.dtos.MessageRequestDTO;
import com.project3.models.MessageResponse;
import com.project3.services.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    MessageService messageService;
    @Operation(summary = "Posts a message", description = "Posts a message for contacting a rental owner.", tags="Post")
    @PostMapping("/api/messages")
    public MessageResponse send(@RequestBody MessageRequestDTO request){
        //Sending message (service -> repo -> DB)
        messageService.sendMessage(request);

        //Response
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Message send with success");
        return messageResponse;
    }
}
