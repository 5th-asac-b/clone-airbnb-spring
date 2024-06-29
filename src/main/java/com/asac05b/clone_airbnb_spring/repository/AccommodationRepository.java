package com.asac05b.clone_airbnb_spring.repository;

import com.asac05b.clone_airbnb_spring.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Integer> {
}
