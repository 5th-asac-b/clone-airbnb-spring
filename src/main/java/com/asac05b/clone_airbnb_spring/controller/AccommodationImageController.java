package com.asac05b.clone_airbnb_spring.controller;

import com.asac05b.clone_airbnb_spring.model.AccommodationImage;
import com.asac05b.clone_airbnb_spring.service.AccommodationImageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/accommodation-images")
public class AccommodationImageController {

    private final AccommodationImageService accommodationImageService;

    @GetMapping
    public ResponseEntity<List<AccommodationImage>> getAllImages() {
        List<AccommodationImage> images = accommodationImageService.getAllImages();
        return ResponseEntity.ok(images);
    }

    @PostMapping
    public ResponseEntity<AccommodationImage> saveImage(@RequestBody AccommodationImage image) {
        AccommodationImage savedImage = accommodationImageService.saveImage(image);
        return ResponseEntity.ok(savedImage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccommodationImage> getImageById(@PathVariable Integer id) {
        try {
            AccommodationImage accommodationImage = accommodationImageService.getImageById(id);
            if (accommodationImage != null) {
                return new ResponseEntity<>(accommodationImage, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<AccommodationImage>> getImagesByAccommodationId(@RequestParam Integer accommodationId) {
        try {
            List<AccommodationImage> images = accommodationImageService.getImagesByAccommodationId(accommodationId);
            return new ResponseEntity<>(images, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}