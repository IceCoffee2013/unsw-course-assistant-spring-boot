package com.doora.api.service;


import com.doora.api.model.Answer;
import com.doora.api.model.Course;
import com.doora.api.model.Question;

import java.util.List;

public interface QuestionService {

    Question addQuestion(Question question);

    Question updateQuestion(Question question);

    void deleteQuestion(Long id);

    Question findQuestionById(Long id);

    List<Question> findQuestionByTitle(String title);

    List<Question> findAllQuestion();

    Answer addAnswer(Answer answer);

    Answer updateAnswer(Answer answer);

    void deleteAnswer(Long id);

    Answer findAnswerById(Long id);

    List<Answer> findAnswerByQuestionId(String questionId);

}