package com.shiv.controller;

import com.shiv.models.Message;
import com.shiv.models.User;
import com.shiv.service.MessageService;
import com.shiv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;


    @PostMapping("/chat/{chatId}")
    public Message createMessage(@RequestBody Message req, @RequestHeader("Authorization") String jwt, @PathVariable Integer chatId) throws Exception {
        User user = userService.findUserByJwt(jwt);
        return messageService.createMessage(user, chatId, req);
    }

    @GetMapping("/chat/{chatId}")
    public List<Message> findChatsMessages(@RequestHeader("Authorization") String jwt, @PathVariable Integer chatId) throws Exception {
        User user = userService.findUserByJwt(jwt);
        return messageService.findChatMessages(chatId);
    }



}
