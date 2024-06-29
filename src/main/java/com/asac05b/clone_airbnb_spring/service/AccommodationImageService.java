package com.asac05b.clone_airbnb_spring.service;

import com.asac05b.clone_airbnb_spring.model.AccommodationImage;
import com.asac05b.clone_airbnb_spring.repository.AccommodationImageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccommodationImageService {

    @Autowired
    private AccommodationImageRepository repository;

    public List<AccommodationImage> getAllImages() {
        return repository.findAll();
    }

    public AccommodationImage saveImage(AccommodationImage image) {
        return repository.save(image);
    }

    public AccommodationImage getImageById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<AccommodationImage> getImagesByAccommodationId(Integer accommodationId) {
        return repository.findByAccommodation_AccommodationId(accommodationId);
    }
}