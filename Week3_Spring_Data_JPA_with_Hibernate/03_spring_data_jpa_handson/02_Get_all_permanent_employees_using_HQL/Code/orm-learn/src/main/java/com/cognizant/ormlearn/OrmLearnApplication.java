package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static EmployeeService employeeService;

    public OrmLearnApplication( @Autowired EmployeeService employeeService) {
        OrmLearnApplication.employeeService = employeeService;
    }

    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start......");

        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees: {}", employees);

        employees.forEach(e -> {
            LOGGER.debug("Employee: {}", e.getName());
            LOGGER.debug("Department: {}", e.getDepartment().getName());
            LOGGER.debug("Skills: {}", e.getSkillList());
        });

        LOGGER.info("End.......");
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);

        testGetAllPermanentEmployees();
    }

}
