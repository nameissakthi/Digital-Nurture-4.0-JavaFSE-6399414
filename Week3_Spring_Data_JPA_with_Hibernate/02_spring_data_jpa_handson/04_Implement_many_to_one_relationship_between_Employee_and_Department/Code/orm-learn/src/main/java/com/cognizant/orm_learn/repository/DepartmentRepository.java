package com.cognizant.orm_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.orm_learn.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
