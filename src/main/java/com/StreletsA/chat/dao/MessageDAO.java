package com.StreletsA.chat.dao;

import com.StreletsA.chat.model.Message;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class MessageDAO {

    private List<Message> messages;

    public MessageDAO(){
        messages = new ArrayList<Message>();

        messages.add(new Message("Andrew", "Hello!"));
        messages.add(new Message("Stew", "Hi!"));
    }

    public List<Message> getMessages(){
        return messages;
    }

    public void addMessage(String sender, String content){
        messages.add(new Message(sender, content));
    }

}
