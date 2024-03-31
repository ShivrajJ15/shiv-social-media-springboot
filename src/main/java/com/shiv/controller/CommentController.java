package com.shiv.controller;

import com.shiv.models.Comment;
import com.shiv.models.User;
import com.shiv.service.CommentService;
import com.shiv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping("/post/{postId}")
    public Comment createComment(@RequestBody Comment comment,
                                 @RequestHeader("Authorization") String jwt,
                                 @PathVariable Integer postId) throws Exception {
        User user = userService.findUserByJwt(jwt);
        return commentService.createComment(comment,postId, user.getId() );
    }

    @PutMapping("/like/{commentId}")
    public Comment likeComment(
                                 @RequestHeader("Authorization") String jwt,
                                 @PathVariable Integer commentId) throws Exception {
        User user = userService.findUserByJwt(jwt);
        return commentService.likeComments(commentId, user.getId()) ;
    }

}
