package com.doora.api.service;

import com.doora.api.model.Answer;
import com.doora.api.model.Question;
import com.doora.api.repository.AnswerRepository;
import com.doora.api.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by langley on 14/9/17.
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.delete(id);
    }

    @Override
    public Question findQuestionById(Long id) {
        return questionRepository.findOne(id);
    }

    @Override
    public List<Question> findQuestionByTitle(String title) {
        return questionRepository.findByTitleContaining(title);
    }

    @Override
    public List<Question> findAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public void updateAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.delete(id);
    }

    @Override
    public Answer findAnswerById(Long id) {
        return answerRepository.findOne(id);
    }

    @Override
    public List<Answer> findAnswerByQuestionId(String questionId) {
        return answerRepository.findByQuestionId(questionId);
    }
}
