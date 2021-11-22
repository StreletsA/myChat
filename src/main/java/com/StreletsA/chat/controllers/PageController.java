package com.StreletsA.chat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
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
