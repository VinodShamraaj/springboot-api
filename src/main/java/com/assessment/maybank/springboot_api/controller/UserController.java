package com.assessment.maybank.springboot_api.controller;

import com.assessment.maybank.springboot_api.model.User;
import com.assessment.maybank.springboot_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        logger.info("Request: Create User {}", user);
        User savedUser = userService.saveUser(user);
        logger.info("Response: {}", savedUser);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getUsers(@RequestParam(defaultValue = "0") int page) {
        Page<User> users = userService.getUsers(page);
        Map<String, Object> response = new HashMap<>();
        response.put("users", users.getContent());
        response.put("totalPages", users.getTotalPages());
        return ResponseEntity.ok(response);
    }
}
