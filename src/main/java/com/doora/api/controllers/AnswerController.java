package com.doora.api.controllers;

import com.doora.api.model.Answer;
import com.doora.api.model.Question;
import com.doora.api.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by langley on 13/9/17.
 */
@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    private final QuestionService questionService;

    @Autowired
    public AnswerController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAnswerByQuestionId(@PathVariable String id) {
        List<Answer> answers = questionService.findAnswerByQuestionId(id);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewAnswer(@RequestBody Answer answer) {
        questionService.addAnswer(answer);
        return new ResponseEntity<>(answer, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAnswerById(@PathVariable Long id) {
        questionService.deleteAnswer(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
