package com.asac05b.clone_airbnb_spring.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Entity
@Table(name = "Accommodation_to_Amenity")
public class AccommodationToAmenity {
    @EmbeddedId
    private AccommodationToAmenityId id;

    @ManyToOne
    @MapsId("accommodationId")
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    @ManyToOne
    @MapsId("amenityId")
    @JoinColumn(name = "amenity_id")
    private Amenity amenity;

}


