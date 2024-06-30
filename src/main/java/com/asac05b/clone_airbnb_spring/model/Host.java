package com.asac05b.clone_airbnb_spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Host")
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    private LocalDateTime hostJoinDate;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer reviewCount;

    @Column(nullable = false, columnDefinition = "decimal(3,2) default 1.00")
    private BigDecimal rating;

    @Column(nullable = false)
    private Boolean isSuperhost;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private Member member;

}
