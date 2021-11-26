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

        messages.add(new Message("26.11.2021 11:38","Andrew", "Hello!"));
        messages.add(new Message("26.11.2021 11:40", "Stew", "Hi!"));
    }

    public List<Message> getMessages(){
        return messages;
    }

    public void addMessage(String date, String sender, String content){
        messages.add(new Message(date, sender, content));
    }

    public void addMessage(Message message){
        messages.add(message);
    }

}
