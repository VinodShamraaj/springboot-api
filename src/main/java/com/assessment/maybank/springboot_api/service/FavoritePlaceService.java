package com.assessment.maybank.springboot_api.service;

import com.assessment.maybank.springboot_api.model.FavoritePlace;
import com.assessment.maybank.springboot_api.repository.FavoritePlaceRepository;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FavoritePlaceService {
    private final FavoritePlaceRepository favoritePlaceRepository;

    @Transactional
    public FavoritePlace saveFavoritePlace(FavoritePlace favoritePlace) {
        return favoritePlaceRepository.save(favoritePlace);
    }

    @Transactional(readOnly = true)
    public Page<FavoritePlace> getFavoritePlaces(int page) {
        return favoritePlaceRepository.findAll(PageRequest.of(page, 5));
    }

    @Transactional(readOnly = true)
    public FavoritePlace getFavoritePlaceByName(String name) {
        return favoritePlaceRepository.findByName(name);
    }
}