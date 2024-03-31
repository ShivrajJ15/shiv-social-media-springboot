package com.shiv.controller;

import com.shiv.models.Chat;
import com.shiv.models.User;
import com.shiv.requests.CreateChatRequest;
import com.shiv.service.ChatService;
import com.shiv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Chat createChat(@RequestHeader("Authorization")String jwt,@RequestBody CreateChatRequest req) throws Exception {

        User reqUser=userService.findUserByJwt(jwt);
        User user2=userService.findUserById(req.getUserId());

        return chatService.createChat(reqUser, user2);
    }

    @GetMapping
    public List<Chat> findUsersChat(@RequestHeader("Authorization")String jwt) {
        User user=userService.findUserByJwt(jwt);
        return chatService.findUsersChat(user.getId());
    }

}
