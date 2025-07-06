package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.ormlearn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}