package com.asac05b.clone_airbnb_spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Accommodation_Image")
public class AccommodationImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;

    @Column(nullable = false)
    private String accommodationImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id", nullable = false)
    private Accommodation accommodation;

}