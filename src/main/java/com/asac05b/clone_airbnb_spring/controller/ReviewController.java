package com.asac05b.clone_airbnb_spring.controller;

import com.asac05b.clone_airbnb_spring.model.Review;
import com.asac05b.clone_airbnb_spring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/accommodations-review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<List<Review>> createdAll(@RequestBody List<Review> reviews) {
        try {
            List<Review> createdReview = reviewService.saveAll(reviews);
            return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReview() {
        List<Review> reviews = reviewService.getAllReview();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getById(@PathVariable Integer id) {
        try {
            Review review = reviewService.getReviewById(id);
            if (review != null) {
                return new ResponseEntity<>(review, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Review>> getReviewsByAccommodationId(@RequestParam Integer accommodation) {
        try {
            List<Review> reviews = reviewService.getReviewByAccommodationId(accommodation);
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
