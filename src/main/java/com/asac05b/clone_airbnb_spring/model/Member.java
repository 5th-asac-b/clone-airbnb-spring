package com.asac05b.clone_airbnb_spring.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime birthday;

    @Column(nullable = false, unique = true)
    private String email;

    private String profileImagePath;

    @Column(nullable = false)
    private LocalDateTime joinDate;

    @Column(nullable = false)
    private String location;

}
