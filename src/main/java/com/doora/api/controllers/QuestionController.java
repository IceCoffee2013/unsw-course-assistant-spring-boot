package com.doora.api.controllers;

import com.doora.api.model.Question;
import com.doora.api.model.User;
import com.doora.api.service.QuestionService;
import com.doora.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by langley on 13/9/17.
 */
@RestController
@RequestMapping("/api/question")
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    @Autowired
    public QuestionController(QuestionService questionService, UserService userService) {
        this.questionService = questionService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllQuestion(@RequestParam(value = "searchText", required = false) String searchText,
                                            HttpServletRequest httpServletRequest) {

        List<Question> questions = new ArrayList<>();
        if (searchText != null && !searchText.isEmpty()) {
            System.out.println("query question: " + searchText);
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
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(username).get();
        question.setAuthor(user.getNickname());
        question.setPostTime(new Date());
        Question newQuestion = questionService.addQuestion(question);
        return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(username).get();
        question.setAuthor(user.getNickname());
        question.setPostTime(new Date());
        Question newQuestion = questionService.updateQuestion(question);
        return new ResponseEntity<>(newQuestion, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQuestionById(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
