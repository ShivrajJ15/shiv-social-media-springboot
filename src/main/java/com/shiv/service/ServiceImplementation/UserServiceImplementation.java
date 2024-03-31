package com.shiv.service.ServiceImplementation;

import com.shiv.config.JwtProvider;
import com.shiv.exceptions.UserNotFoundException;
import com.shiv.models.User;
import com.shiv.repository.UserRepository;
import com.shiv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User registerUser(User user) {
        return null;
    }

    @Override
    public User findUserById(Integer userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserNotFoundException("User Not Exists By id " + userId);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User followUser(Integer reqUserId1, Integer userId2) throws UserNotFoundException {
        User reqUser = findUserById(reqUserId1);
        User user2 = findUserById(userId2);

        if (reqUser == null || user2 == null) {
            throw new UserNotFoundException("User(s) not found");
        }

        user2.getFollowers().add(reqUser.getId()); // Add user1 to user2's followers list
        reqUser.getFollowings().add(user2.getId()); // Add user2 to user1's followings list

        userRepository.save(reqUser);
        userRepository.save(user2);

        return reqUser ; // Or you can return user2, depending on your use case
    }

    @Override
    public User updateUser(User user, Integer userId) throws UserNotFoundException {

        Optional<User> user1 = userRepository.findById(userId);
        if (user1.isEmpty()) {
            throw new UserNotFoundException("User Not Exist with Id " + userId);
        }
        User oldUser = user1.get();

        if (user.getFirstName() != null) {
            oldUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            oldUser.setLastName(user.getLastName());
        }
        if (user.getEmail() != null) {
            oldUser.setEmail(user.getEmail());
        }
        if (user.getPassword() != null) {
            oldUser.setPassword(user.getPassword());
        }
        if (user.getId() != null) {
            oldUser.setId(user.getId());
        }
        if (user.getGender() != null) {
            oldUser.setGender(user.getGender());
        }
        return userRepository.save(oldUser);
    }

    @Override
    public List<User> searchUser(String query) {
        return userRepository.searchUser(query);
    }

    @Override
    public User findUserByJwt(String jwt) {
        String email = JwtProvider.getEmailFromJwtToken(jwt);
        return userRepository.findByEmail(email);

    }
}
