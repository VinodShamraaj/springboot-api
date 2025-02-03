package com.assessment.maybank.springboot_api.repository;

import com.assessment.maybank.springboot_api.model.FavoritePlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritePlaceRepository extends JpaRepository<FavoritePlace, Long> {
    FavoritePlace findByName(String name);
}