package com.doora.api.controllers;

import com.doora.api.model.User;
import com.doora.api.repository.UserRepository;
import com.doora.api.dto.UserDTO;
import com.doora.api.security.JwtTokenHandler;
import com.doora.api.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by langley on 5/5/17.
 */
@RestController
@RequestMapping("/api/register")
public class LoginController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtTokenHandler jwtTokenHandler;

    @Autowired
    public LoginController(UserRepository userRepository, UserService userService, JwtTokenHandler jwtTokenHandler) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.jwtTokenHandler = jwtTokenHandler;
    }

    @ApiOperation(value = "create users", response = ResponseEntity.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@Valid @RequestBody UserDTO params) {
        User newUser = userService.createUser(params);
//        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(newUser, HttpStatus.OK);
    }

}
