package com.asac05b.clone_airbnb_spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Amenity")
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer amenityId;

    private String amenityIcon;

}
