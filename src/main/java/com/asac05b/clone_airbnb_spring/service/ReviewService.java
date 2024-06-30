package com.asac05b.clone_airbnb_spring.service;

import com.asac05b.clone_airbnb_spring.model.Review;
import com.asac05b.clone_airbnb_spring.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository repository;

    public List<Review> saveAll(List<Review> reviews) {
        return repository.saveAll(reviews);
    }

    public List<Review> getAllReview() {
        return repository.findAll();
    }

    public Review getReviewById(Integer id) {
        return repository.findById(id).orElse(null);
    }


    public List<Review> getReviewByAccommodationId(Integer accommodationId) {
        return repository.findByAccommodationAccommodationId(accommodationId);
    }
}
