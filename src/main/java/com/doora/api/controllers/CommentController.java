package com.doora.api.controllers;

import com.doora.api.model.Answer;
import com.doora.api.model.Comment;
import com.doora.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by langley on 13/9/17.
 */
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCommentByPostId(@PathVariable String id) {
        List<Comment> comments = commentService.findCommentByPostId(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addComment(@RequestBody Comment comment) {
//        questionService.addAnswer(answer); TODO
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCommentById(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
