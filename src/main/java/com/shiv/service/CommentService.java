package com.shiv.service;

import com.shiv.models.Comment;

public interface CommentService {

    public Comment createComment(Comment comment,
                                 Integer postId,
                                 Integer userId) throws Exception;

    public Comment findCommentById(Integer commentId) throws Exception;

    public Comment likeComments(Integer commentId, Integer userId) throws Exception;
}
