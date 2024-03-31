package com.shiv.service;

import com.shiv.exceptions.UserNotFoundException;
import com.shiv.models.User;

import java.util.List;

public interface UserService {
    public User registerUser(User user);

    public User findUserById(Integer userId) throws UserNotFoundException;

    public User findUserByEmail(String email);

    public User followUser(Integer userId1, Integer userId2) throws UserNotFoundException;

    public User updateUser(User user, Integer userId) throws UserNotFoundException;

    public List<User> searchUser(String query);

    public User findUserByJwt(String jwt);
}
