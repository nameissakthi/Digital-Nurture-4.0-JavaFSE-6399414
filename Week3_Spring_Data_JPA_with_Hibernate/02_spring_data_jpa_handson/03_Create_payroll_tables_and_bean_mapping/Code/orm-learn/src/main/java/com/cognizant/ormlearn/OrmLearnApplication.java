package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.DepartmentRepository;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import com.cognizant.ormlearn.repository.SkillRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void testPayroll(ApplicationContext context) {
        LOGGER.info("Start.....");

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        Employee employee = employeeRepository.findById(1).get();
        LOGGER.info("Employee : {}", employee);

        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
        Department department = departmentRepository.findById(1).get();
        LOGGER.info("Department : {}", department);

        SkillRepository skillRepository = context.getBean(SkillRepository.class);
        Skill skill = skillRepository.findById(1).get();
        LOGGER.info("Skill : {}", skill);

        LOGGER.info("End.....");
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        testPayroll(context);
    }

}