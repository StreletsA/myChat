package com.StreletsA.chat.controllers;

import com.StreletsA.chat.entity.Message;
import com.StreletsA.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @CrossOrigin
    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }

    @CrossOrigin
    @PostMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMessage(@RequestBody Message message){
        messageService.addMessage(message);
    }

}

