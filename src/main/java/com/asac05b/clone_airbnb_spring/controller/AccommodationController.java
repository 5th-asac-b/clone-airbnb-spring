package com.asac05b.clone_airbnb_spring.controller;

import com.asac05b.clone_airbnb_spring.model.Accommodation;
import com.asac05b.clone_airbnb_spring.service.AccommodationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    @PostMapping
    public ResponseEntity<List<Accommodation>> create(@RequestBody List<Accommodation> accommodations) {
        try {
            List<Accommodation> createdAccommodations = accommodationService.saveAll(accommodations);
            return new ResponseEntity<>(createdAccommodations, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Accommodation>> getAll() {
        try {
            List<Accommodation> accommodations = accommodationService.findAll();
            return new ResponseEntity<>(accommodations, HttpStatus.OK);

        } catch (Exception e) {
//            return new ResponseEntity<>(e., HttpStatus.INTERNAL_SERVER_ERROR);
            System.out.println(e.getStackTrace());
            return null;
            // 더러운 예왜처리, 예외처리 중앙화 (Custom Error)
        }
    }

}
