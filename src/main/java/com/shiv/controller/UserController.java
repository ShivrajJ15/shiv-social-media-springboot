package com.shiv.controller;


import com.shiv.config.JwtProvider;
import com.shiv.exceptions.UserNotFoundException;
import com.shiv.models.User;
import com.shiv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("{userId}")
    public User getUserById(@PathVariable("userId") Integer id) throws UserNotFoundException {
        return userService.findUserById(id);
    }

    @PutMapping
    public User updateUser(@RequestHeader("Authorization") String jwt, @RequestBody User user) throws UserNotFoundException {
        User requestedUser = userService.findUserByJwt(jwt);
        return userService.updateUser(user, requestedUser.getId());
    }

    @PutMapping("/{userId2}")
    public User followUserHandler( @RequestHeader("Authorization") String jwt,@PathVariable Integer userId2) throws UserNotFoundException {
        User reqUser= userService.findUserByJwt(jwt);
        return userService.followUser(reqUser.getId(), userId2);
    }

    @GetMapping("/search")
    public List<User> searchUser(@RequestParam("query") String query) {
        return userService.searchUser(query);
    }


    @GetMapping("/profile")
    public User getUserFromToken(@RequestHeader("Authorization") String jwt) {
        User user = userService.findUserByJwt(jwt);
        user.setPassword(null);
        return user;
    }


}
