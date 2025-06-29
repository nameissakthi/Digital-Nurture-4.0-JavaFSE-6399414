package com.example.TestControllerExcepHandling.repository;

import com.example.TestControllerExcepHandling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
