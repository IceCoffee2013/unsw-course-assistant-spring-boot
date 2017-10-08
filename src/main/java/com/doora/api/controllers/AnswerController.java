package com.doora.api.controllers;

import com.doora.api.dto.AnswerDTO;
import com.doora.api.model.Answer;
import com.doora.api.model.Question;
import com.doora.api.model.User;
import com.doora.api.service.QuestionService;
import com.doora.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by langley on 13/9/17.
 */
@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    private final UserService userService;
    private final QuestionService questionService;

    @Autowired
    public AnswerController(UserService userService, QuestionService questionService) {
        this.userService = userService;
        this.questionService = questionService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAnswerByQuestionId(@PathVariable String id) {
        List<Answer> answers = questionService.findAnswerByQuestionId(id);
        List<AnswerDTO> dtos = new ArrayList<>();

        for (Answer answer : answers) {
            dtos.add(toDTO(answer));
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewAnswer(@RequestBody Answer answer) {
        answer.setPostTime(new Date());
        answer.setLikes(0);
        Answer tmp = this.questionService.addAnswer(answer);
        AnswerDTO dto = toDTO(tmp);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAnswerById(@PathVariable Long id) {
        questionService.deleteAnswer(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    private AnswerDTO toDTO(Answer answer) {
        AnswerDTO dto = new AnswerDTO(answer);
        User user = userService.findUserByUsername(answer.getAuthor()).get();
        dto.setAvatar(user.getAvatar());
        return dto;
    }

}
