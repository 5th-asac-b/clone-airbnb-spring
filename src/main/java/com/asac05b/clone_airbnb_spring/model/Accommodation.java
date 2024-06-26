package com.asac05b.clone_airbnb_spring.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Accommodation")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accommodationId;

    @Column(nullable = false)
    private String accommodationName;

    @Column(nullable = false)
    private String locationName;

    @Column(nullable = false)
    private String locationAlias;

    @Column(nullable = false)
    private Boolean guestFavorite;

    @Column(nullable = false, columnDefinition = "decimal(3,2) default 1.00")
    private BigDecimal accommodationRating;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer reviewCount;

    @Column(nullable = false)
    private Integer accommodation_price;
}
