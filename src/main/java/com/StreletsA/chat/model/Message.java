package com.StreletsA.chat.model;


public class Message {

    private String date;
    private String sender;
    private String content;

    public Message(String date, String sender, String content){
        this.date = date;
        this.sender = sender;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }
}
