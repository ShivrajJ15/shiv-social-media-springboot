package com.shiv.service;

import com.shiv.models.Chat;
import com.shiv.models.User;

import java.util.List;

public interface ChatService {
    public Chat createChat(User reqUser,User user2);

    public Chat findChatById(Integer chatId) throws Exception;

    public List<Chat>  findUsersChat(Integer userId);
}
