package com.StreletsA.chat.controllers;

import com.StreletsA.chat.dao.MessageDAO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

