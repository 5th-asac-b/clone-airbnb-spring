package com.asac05b.clone_airbnb_spring.dto;

import com.asac05b.clone_airbnb_spring.model.Accommodation;
import java.math.BigDecimal;


public class AccommodationDTO {
    private Integer accommodationId;
    private String accommodationName;
    private String locationName;
    private String locationAlias;
    private Boolean guestFavorite;
    private BigDecimal accommodationRating;
    private Integer reviewCount;
    private Integer accommodationPrice;


    // Dto 수정, Dto를 통해 필요한 데이터만 반환하도록 구현
//    public Accommodation of() {
//        return new Accommodation(accommodationId, accommodationName, locationName,
//                locationAlias, guestFavorite, accommodationRating, reviewCount, accommodationPrice);
//    }
}
