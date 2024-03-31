package com.shiv.service;

import com.shiv.models.Post;

import java.util.List;

public interface PostService {

   public Post createPost(Post post, Integer userId) throws Exception;

   public String deletePost(Integer postId, Integer userId) throws Exception;

   public List<Post> findPostByUserId(Integer userId);

   public Post findPostById(Integer postId) throws Exception;

   public List<Post> findAllPost();

   public Post savedPost(Integer postId,Integer userId) throws Exception;

   public Post likedPost(Integer postId,Integer userId) throws Exception;
}
