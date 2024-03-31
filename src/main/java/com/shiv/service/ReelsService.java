package com.shiv.service;

import com.shiv.models.Reels;
import com.shiv.models.User;

import java.util.List;

public interface ReelsService {
     public Reels createReel(Reels reel, User user);
     public List<Reels> findAllReels();
     public List<Reels> findUsersReels(Integer userId) throws Exception;
}
