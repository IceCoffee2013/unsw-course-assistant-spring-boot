package com.doora.api.repository;

import com.doora.api.model.Comment;
import com.doora.api.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by langley on 8/5/17.
 */
public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
