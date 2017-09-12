package com.doora.api.controllers;

import com.doora.api.dto.ApplicationDTO;
import com.doora.api.repository.UserRepository;
import com.doora.api.model.Application;
import com.doora.api.security.JwtTokenHandler;
import com.doora.api.service.JobService;
import com.doora.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by langley on 8/5/17.
 */
@RestController
@RequestMapping("/api/apply")
public class ApplyController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final JobService jobService;

    @Autowired
    public ApplyController(UserRepository userRepository, UserService userService, JobService jobService, JwtTokenHandler jwtTokenHandler) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.jobService = jobService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllApplications() {
        List<Application> applications =  jobService.findAllApplication();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        Application application = jobService.findApplicationByID(id);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Application> addNewApplication(@RequestBody Application application) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        application.setUserID(username);
        application.setEmail(username);
        jobService.addApplication(application);
        return new ResponseEntity<>(application, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Application> updateApplication(@RequestBody Application application) {
        jobService.updateApplication(application);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @RequestMapping(value = "/combo", method = RequestMethod.GET)
    public ResponseEntity<?> getAllApplicationCombo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<ApplicationDTO> applicationDTOS = jobService.findApplicationComboByPublisher(username);
        return new ResponseEntity<>(applicationDTOS, HttpStatus.OK);
    }

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public ResponseEntity<?> getMyApplications() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Application> applications =  jobService.findApplicationByApplicant(username);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

}
