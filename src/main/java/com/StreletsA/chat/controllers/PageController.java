package com.StreletsA.chat.controllers;

import com.StreletsA.chat.dao.MessageDAO;
import com.StreletsA.chat.model.Message;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Controller
public class PageController {

    private MessageDAO messageDAO;

    @Autowired
    public PageController(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false) String name, Model model){

        if(name == null)
            model.addAttribute("name", "Nothing");
        else
            model.addAttribute("name", name);

        return "hello";
    }
}
