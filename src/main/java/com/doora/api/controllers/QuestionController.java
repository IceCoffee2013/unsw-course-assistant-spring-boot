package com.doora.api.controllers;

import com.doora.api.model.Course;
import com.doora.api.model.Question;
import com.doora.api.service.CourseService;
import com.doora.api.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by langley on 13/9/17.
 */
@RestController
@RequestMapping("/api/question")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllQuestion(@RequestParam(value = "searchText", required = false) String searchText) {
        List<Question> questions = new ArrayList<>();
        if (searchText != null && !searchText.isEmpty()) {
            questions = questionService.findQuestionByTitle(searchText);
        } else {
            questions = questionService.findAllQuestion();
        }
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getQuestionById(@PathVariable Long id) {
        Question question = questionService.findQuestionById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewQuestion(@RequestBody Question question) {
        question.setPostTime(new Date());
        questionService.addQuestion(question);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQuestionById(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
