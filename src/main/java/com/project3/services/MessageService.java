package com.project3.services;

import com.project3.entities.Message;
import com.project3.dtos.MessageRequestDTO;
import com.project3.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public void sendMessage(MessageRequestDTO request) {
        Message message = new Message(request.getMessage(), request.getRental_id(), request.getUser_id());
        messageRepository.save(message);
    }
}
