package com.shiv.service.ServiceImplementation;

import com.shiv.models.Reels;
import com.shiv.models.User;
import com.shiv.repository.ReelsRepository;
import com.shiv.service.ReelsService;
import com.shiv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReelsServiceImplementation implements ReelsService {

    @Autowired
    private ReelsRepository reelsRepository;

    @Autowired
    private UserService userService;

    @Override
    public Reels createReel(Reels reel, User user) {
        Reels createReel=new Reels();
        createReel.setTitle(reel.getTitle());
        createReel.setVideo(reel.getVideo());
        createReel.setUser(user);
        return reelsRepository.save(createReel);
    }

    @Override
    public List<Reels> findAllReels() {
        return reelsRepository.findAll();
    }

    @Override
    public List<Reels> findUsersReels(Integer userId) throws Exception {
        userService.findUserById(userId);
        return reelsRepository.findByUserId(userId);
    }

}
