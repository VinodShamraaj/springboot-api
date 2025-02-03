package com.assessment.maybank.springboot_api.controller;

import com.assessment.maybank.springboot_api.model.User;
import com.assessment.maybank.springboot_api.service.UserService;
import com.assessment.maybank.springboot_api.dto.UpdateUserDTO;
import com.assessment.maybank.springboot_api.dto.ResponseDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO<User>> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);

        ResponseDTO<User> response = new ResponseDTO("User created successfully", savedUser);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getUsers(@RequestParam(defaultValue = "0") int page) {
        Page<User> users = userService.getUsers(page);
        Map<String, Object> response = new HashMap<>();
        response.put("users", users.getContent());
        response.put("totalPages", users.getTotalPages());
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<User>> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);

        ResponseDTO<User> response = new ResponseDTO<>("User retrieved successfully", user);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO<User>> updateUser(@PathVariable Long id,@RequestBody UpdateUserDTO updateUserDTO) {
        User updatedUser = userService.updateUser(id, updateUserDTO);

        ResponseDTO<User> response = new ResponseDTO("User updated successfully", updatedUser);
        
        return ResponseEntity.ok(response);
    }
}
