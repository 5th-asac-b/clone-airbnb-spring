package com.asac05b.clone_airbnb_spring.repository;

import com.asac05b.clone_airbnb_spring.model.AccommodationImage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationImageRepository extends JpaRepository<AccommodationImage, Integer> {
    List<AccommodationImage> findByAccommodation_AccommodationId(Integer accommodationId);
}