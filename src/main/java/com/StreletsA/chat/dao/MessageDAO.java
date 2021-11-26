package com.StreletsA.chat.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class MessageDAO {

    private List<String> messages;

    public MessageDAO(){
        messages = new ArrayList<>();

        messages.add("Nice!");
        messages.add("Hi bro");
    }

}
