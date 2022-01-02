package com.StreletsA.chat.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "accounts")
@Setter
@Getter
public class Account {

    @Id
    private String id;
    private String name;
    private List<String> friendIds;

}
