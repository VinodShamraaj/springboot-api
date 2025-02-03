package com.assessment.maybank.springboot_api.repository;

import com.assessment.maybank.springboot_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}