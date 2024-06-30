package com.asac05b.clone_airbnb_spring.repository;

import com.asac05b.clone_airbnb_spring.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByAccommodationAccommodationId(Integer accommodationId);
}
