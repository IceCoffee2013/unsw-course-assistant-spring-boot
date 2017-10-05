package com.doora.api.repository;

import com.doora.api.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by langley on 8/5/17.
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findByQuestionId(String questionId);

}
