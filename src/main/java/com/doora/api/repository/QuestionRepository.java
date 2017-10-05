package com.doora.api.repository;

import com.doora.api.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by langley on 8/5/17.
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByTitleContaining(String title);

}
