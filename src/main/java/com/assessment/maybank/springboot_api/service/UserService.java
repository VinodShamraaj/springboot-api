package com.assessment.maybank.springboot_api.service;

import com.assessment.maybank.springboot_api.model.User;
import com.assessment.maybank.springboot_api.repository.UserRepository;
import com.assessment.maybank.springboot_api.dto.UpdateUserDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Page<User> getUsers(int page) {
        return userRepository.findAll(PageRequest.of(page, 10));
    }

    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        return user;
    }

    @Transactional
    public User updateUser(Long id, UpdateUserDTO updateUserDTO) {
        // Find the user by ID
        User user = this.getUserById(id);

        // Update the user fields
        user.setName(updateUserDTO.getName());
        user.setEmail(updateUserDTO.getEmail());

        // Save and return the updated user
        return userRepository.save(user);
    }
}