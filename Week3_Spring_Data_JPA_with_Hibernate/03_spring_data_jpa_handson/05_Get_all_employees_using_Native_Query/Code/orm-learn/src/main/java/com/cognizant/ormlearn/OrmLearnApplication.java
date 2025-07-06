package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        testGetAllEmployeesWithSkills(context);
    }

    public static void testGetAllEmployeesWithSkills(ApplicationContext context) {

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        List<Employee> employees = employeeService.getAllEmployeesWithSkills();
        for (Employee emp : employees) {
            System.out.println(emp);
            System.out.println("Skills: " + emp.getSkillList());
        }
    }
}
