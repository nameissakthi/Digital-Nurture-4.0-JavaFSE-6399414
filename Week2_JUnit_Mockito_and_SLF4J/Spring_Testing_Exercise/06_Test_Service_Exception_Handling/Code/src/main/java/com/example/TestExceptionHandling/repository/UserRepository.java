package com.example.TestExceptionHandling.repository;

import com.example.TestExceptionHandling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
