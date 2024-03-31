package com.shiv.service;

import com.shiv.models.Chat;
import com.shiv.models.Message;
import com.shiv.models.User;

import java.util.List;

public interface MessageService {

    public Message createMessage(User user, Integer chatId, Message req) throws Exception;

    public List<Message> findChatMessages(Integer chatId) throws Exception;
}
