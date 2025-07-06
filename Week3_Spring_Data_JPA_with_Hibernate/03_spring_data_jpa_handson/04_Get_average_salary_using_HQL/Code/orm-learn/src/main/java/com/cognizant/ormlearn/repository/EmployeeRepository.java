package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT AVG(e.salary) FROM Employee e")
    Double getAverageSalary();

    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    Double getAverageSalary(@Param("id") int id);
}