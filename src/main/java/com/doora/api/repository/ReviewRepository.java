package com.doora.api.repository;

import com.doora.api.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by langley on 8/5/17.
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByApplicationID(String applicationID);

    Review findByApplicationIDAndReviewerID(String applicationID, String reviewerID);

}
