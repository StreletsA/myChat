package com.StreletsA.chat.controllers;

import com.StreletsA.chat.dao.MessageDAO;
import com.StreletsA.chat.model.Message;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
@RequestMapping("/api")
public class ApiController {

    private MessageDAO messageDAO;

    @Autowired
    public ApiController(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }

    @CrossOrigin
    @GetMapping(value="/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMessages(){
        return new Gson().toJson(messageDAO.getMessages());
    }

    @CrossOrigin
    @PostMapping(value="/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> addMessage(@RequestBody Message message) throws ServerException {
        if (message == null) {
            throw new ServerException("Exception on addMessage");
        } else {
            messageDAO.addMessage(message);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
    }

}

