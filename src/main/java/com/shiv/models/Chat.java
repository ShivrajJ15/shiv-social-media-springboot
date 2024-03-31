package com.shiv.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String chat_name;

    @ManyToMany
    private List<User> users=new ArrayList<>();
    private LocalDateTime timestamp;

    @OneToMany(mappedBy = "chat")
    private List<Message> messages=new ArrayList<>();

    public Chat() {
    }

    public Chat(Integer id, String chat_name, List<User> users, LocalDateTime timestamp, List<Message> messages) {
        this.id = id;
        this.chat_name = chat_name;
        this.users = users;
        this.timestamp = timestamp;
        this.messages = messages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
