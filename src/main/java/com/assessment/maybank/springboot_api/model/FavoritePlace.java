package com.assessment.maybank.springboot_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favoriteLocations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FavoritePlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Double lat;

    @Column(nullable = false)
    private Double lng;

}

