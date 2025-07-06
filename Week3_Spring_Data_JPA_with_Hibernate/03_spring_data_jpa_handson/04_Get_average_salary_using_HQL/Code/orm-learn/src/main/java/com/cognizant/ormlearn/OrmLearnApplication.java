package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.service.EmployeeService;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        testGetAverageSalary(context);
    }

    public static void testGetAverageSalary(ApplicationContext context) {
        EmployeeService employeeService = context.getBean(EmployeeService.class);

        int departmentId = 1;
        Double avgSalary = employeeService.getAverageSalary(departmentId);
        if (avgSalary != null) {
            System.out.println("Average salary for Department ID " + departmentId + ": " + avgSalary);
        } else {
            System.out.println("No employees found in Department ID " + departmentId);
        }
    }
}
