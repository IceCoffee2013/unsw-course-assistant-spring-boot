package com.doora.api.service;


import com.doora.api.model.Comment;
import com.doora.api.model.Course;
import com.doora.api.model.Reply;

import java.util.List;

public interface CommentService {

    Comment addComment(Comment comment);

    Comment updateComment(Comment comment);

    void deleteComment(Long id);

    Comment findCommentById(Long id);

    List<Comment> findCommentByPostId(String postId);

    List<Comment> findAllComment();

    Reply findReplyById(Long id);

    void addReply(Reply reply);

    void deleteReply(Long id);

}