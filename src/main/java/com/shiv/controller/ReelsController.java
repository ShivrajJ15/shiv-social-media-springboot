package com.shiv.controller;

import com.shiv.models.Reels;
import com.shiv.models.User;
import com.shiv.service.ReelsService;
import com.shiv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reels")
public class ReelsController {
    @Autowired
    private ReelsService reelsService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Reels createReels(@RequestBody Reels reel, @RequestHeader("Authorization") String jwt) throws Exception {
        User reqUser = userService.findUserByJwt(jwt);
        if(reqUser==null){
            throw new Exception("User Does Not Exists");
        }
        return reelsService.createReel(reel, reqUser);
    }

    @GetMapping
    public List<Reels> findAllReels(){
        return reelsService.findAllReels();
    }

    @GetMapping("/user/{userId}")
    public List<Reels> findUsersReels(@PathVariable Integer userId) throws Exception {
        return reelsService.findUsersReels(userId);
    }

}

