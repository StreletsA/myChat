package com.StreletsA.chat.dao;

import com.StreletsA.chat.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class MessageDAO {

    private static final String dataUrl = "jdbc:postgresql://localhost:5432/myChat_db";
    private static final String username = "postgres";;
    private static final String password = "12345678";;
    private static Connection connection;

    //
    static {
        // We load driver to operating memory
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(dataUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public MessageDAO(){
    }

    public List<Message> getMessages(){

        List<Message> messages = new ArrayList<Message>();

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM message";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Message message = new Message(
                        resultSet.getString("date"),
                        resultSet.getString("sender"),
                        resultSet.getString("content")
                );

                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }

    public void addMessage(String date, String sender, String content){
        try {
            Statement statement = connection.createStatement();
            String sql = String.format("INSERT INTO message VALUES (\'%s\', \'%s\', \'%s\')",
                    date,
                    sender,
                    content);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMessage(Message message){
        String date = message.getDate();
        String sender = message.getSender();
        String content = message.getContent();

        addMessage(date, sender, content);
    }

}
