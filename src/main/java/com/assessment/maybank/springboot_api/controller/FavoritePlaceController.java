package com.assessment.maybank.springboot_api.controller;

import com.assessment.maybank.springboot_api.model.FavoritePlace;
import com.assessment.maybank.springboot_api.service.FavoritePlaceService;
import com.assessment.maybank.springboot_api.dto.ResponseDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/favorite")
@RequiredArgsConstructor
public class FavoritePlaceController {
    private final FavoritePlaceService favoritePlaceService;

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO<FavoritePlace>> createFavoritePlace(@RequestBody FavoritePlace user) {
        FavoritePlace savedFavoritePlace = favoritePlaceService.saveFavoritePlace(user);

        ResponseDTO<FavoritePlace> response = new ResponseDTO("Favorite place added successfully", savedFavoritePlace);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getFavoritePlaces(@RequestParam(defaultValue = "0") int page) {
        Page<FavoritePlace> favoritePlaces = favoritePlaceService.getFavoritePlaces(page);
        Map<String, Object> response = new HashMap<>();
        response.put("users", favoritePlaces.getContent());
        response.put("totalPages", favoritePlaces.getTotalPages());
        return ResponseEntity.ok(response);
    }
    
    // @GetMapping("/{name}")
    // public ResponseEntity<ResponseDTO<User>> getUserById(@PathVariable Long id) {
    //     User user = userService.getUserById(id);

    //     ResponseDTO<User> response = new ResponseDTO<>("User retrieved successfully", user);

    //     return ResponseEntity.ok(response);
    // }
}
