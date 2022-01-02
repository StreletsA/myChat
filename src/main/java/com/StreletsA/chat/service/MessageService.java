package com.StreletsA.chat.service;

import com.StreletsA.chat.entity.Account;
import com.StreletsA.chat.entity.Message;
import com.StreletsA.chat.repository.MessageRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages(){

        List<Message> messages = messageRepository.findAll();

        if(messages == null)
            throw new IllegalStateException("No messages");

        return messages;

    }

    @NonNull
    public void addMessage(String date, String senderAccountId, String content){

        Message message = new Message();

        message.setDate(date);
        message.setSenderAccountId(senderAccountId);
        message.setContent(content);

        addMessage(message);

    }

    @NonNull
    public void addMessage(Message message){
        messageRepository.insert(message);
    }

}
