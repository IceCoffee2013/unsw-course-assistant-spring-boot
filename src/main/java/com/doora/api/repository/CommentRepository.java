package com.doora.api.repository;

import com.doora.api.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by langley on 8/5/17.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostId(String postId);

}
