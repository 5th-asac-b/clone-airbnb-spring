package com.asac05b.clone_airbnb_spring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Accommodation")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accommodationId;

    @Column(nullable = false)
    private String accommodationName;

    @Column(nullable = false, columnDefinition = "decimal(3,2) default 1.00")
    private BigDecimal accommodationRating;

    @Column(nullable = false)
    private Boolean guestFavorite;

    @Column(nullable = false)
    private String locationAlias;

    @Column(nullable = false)
    private String locationName;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer reviewCount;

    @Column(nullable = false)
    private Integer accommodationPrice;

    @OneToMany(mappedBy = "accommodation")
    @JsonManagedReference
    private List<AccommodationImage> images;

    @OneToMany(mappedBy = "accommodation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Host> hosts;
}
