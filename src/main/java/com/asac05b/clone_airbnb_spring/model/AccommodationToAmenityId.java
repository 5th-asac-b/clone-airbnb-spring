package com.asac05b.clone_airbnb_spring.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
public class AccommodationToAmenityId implements Serializable {
    private Integer accommodationId;
    private Integer amenityId;
}
