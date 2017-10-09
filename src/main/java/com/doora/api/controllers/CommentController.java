package com.doora.api.controllers;

import com.doora.api.dto.CommentDTO;
import com.doora.api.model.Comment;
import com.doora.api.model.Reply;
import com.doora.api.model.User;
import com.doora.api.service.CommentService;
import com.doora.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by langley on 13/9/17.
 */
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final UserService userService;
    private final CommentService commentService;

    @Autowired
    public CommentController(UserService userService, CommentService commentService) {
        this.userService = userService;
        this.commentService = commentService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<CommentDTO>> getCommentByPostId(@PathVariable String id,
                                                               @RequestParam(value = "type") String type) {
        String postId = type + "_" + id;
        List<Comment> comments = commentService.findCommentByPostId(postId);
        List<CommentDTO> dtos = new ArrayList<>();
        for (Comment comment : comments) {
            dtos.add(toDTO(comment));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CommentDTO> addComment(@RequestBody Comment comment,
                                                 @RequestParam(value = "type") String type) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(username).get();
        String postId = type + "_" + comment.getPostId();
        comment.setPostId(postId);
        comment.setPostTime(new Date());
        comment.setCommenter(user.getUsername());

        Comment newComment = this.commentService.addComment(comment);
        CommentDTO dto = toDTO(newComment);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCommentById(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public ResponseEntity<Comment> addReply(@RequestBody Reply reply) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(username).get();
        reply.setReplier(user.getUsername());
        reply.setReplyTime(new Date());

        Comment comment = this.commentService.findCommentById(Long.parseLong(reply.getCommentId()));
        comment.getReplies().add(reply);
        this.commentService.updateComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/reply/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteReplyById(@PathVariable Long id) {
        Reply reply = this.commentService.findReplyById(id);
        Comment comment = this.commentService.findCommentById(Long.parseLong(reply.getCommentId()));
        Iterator<Reply> iterator = comment.getReplies().iterator();

        while (iterator.hasNext()) {
            Reply tmp = iterator.next();
            if (tmp.getId() == id) {
                iterator.remove();
                break;
            }
        }
        commentService.updateComment(comment);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    private CommentDTO toDTO(Comment comment) {
        CommentDTO dto = new CommentDTO(comment);
        User user = userService.findUserByUsername(comment.getCommenter()).get();
        dto.setAvatar(user.getAvatar());
        return dto;
    }


}
