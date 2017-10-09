package com.doora.api.service;

import com.doora.api.model.Comment;
import com.doora.api.model.Reply;
import com.doora.api.repository.CommentRepository;
import com.doora.api.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by langley on 14/9/17.
 */

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private ReplyRepository replyRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ReplyRepository replyRepository) {
        this.commentRepository = commentRepository;
        this.replyRepository = replyRepository;
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.delete(id);
    }

    @Override
    public Comment findCommentById(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public List<Comment> findAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public Reply findReplyById(Long id) {
        return replyRepository.findOne(id);
    }

    @Override
    public void addReply(Reply reply) {
        replyRepository.save(reply);
    }

    @Override
    public void deleteReply(Long id) {
        replyRepository.delete(id);
    }

    @Override
    public List<Comment> findCommentByPostId(String postId) {
        return commentRepository.findByPostId(postId);
    }
}
