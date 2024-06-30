package com.asac05b.clone_airbnb_spring.repository;

import com.asac05b.clone_airbnb_spring.model.Host;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host, Integer> {
    List<Host> findByAccommodation_AccommodationId(Integer accommodationId);
}