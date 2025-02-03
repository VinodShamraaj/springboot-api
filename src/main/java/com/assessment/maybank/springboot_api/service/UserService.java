package com.assessment.maybank.springboot_api.service;

import com.assessment.maybank.springboot_api.model.User;
import com.assessment.maybank.springboot_api.repository.UserRepository;
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
}