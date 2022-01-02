package com.StreletsA.chat.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
@Getter
@Setter
public class Message {

    @Id
    private String id;

    private String date;
    private String senderAccountId;
    private String content;

}
