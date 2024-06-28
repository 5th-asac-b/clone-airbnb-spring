package com.asac05b.clone_airbnb_spring.service;

import com.asac05b.clone_airbnb_spring.AccommodationRepository;
import com.asac05b.clone_airbnb_spring.model.Accommodation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public List<Accommodation> saveAll(List<Accommodation> accommodations) {
        return accommodationRepository.saveAll(accommodations);
    }

    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }


}
