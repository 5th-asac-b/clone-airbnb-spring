package com.asac05b.clone_airbnb_spring;

import com.asac05b.clone_airbnb_spring.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Integer> {
}
