package com.doora.api.service;


import com.doora.api.dto.ApplicationDTO;
import com.doora.api.dto.ReviewDTO;
import com.doora.api.model.Application;
import com.doora.api.model.Job;
import com.doora.api.model.Review;

import java.util.List;

public interface JobService {

    void addJob(Job job);

    void updateJob(Job job);

    void deleteJob(Long id);

    boolean existJob(Long id);

    Job findJobByID(Long id);

    /**
     *
     * @param publisher username.
     * @return
     */
    List<Job> findJobByPublisher(String publisher);

    List<Job> findJobByName(String name);

    List<Job> findAllJob();

    void addApplication(Application application);

    void updateApplication(Application application);

    Application findApplicationByID(Long id);

    List<Application> findApplicationByJobID(String jobID);

    List<Application> findAllApplication();

    List<Application> findApplicationByApplicant(String applicant);

    void addReview(Review review);

    void updateReview(Review review);

    Review findReviewByID(Long id);

    List<Review> findReviewByAppID(String appID);

    List<ReviewDTO> findReviewComboByUserID(String username);

    List<ApplicationDTO> findApplicationComboByPublisher(String username);

}