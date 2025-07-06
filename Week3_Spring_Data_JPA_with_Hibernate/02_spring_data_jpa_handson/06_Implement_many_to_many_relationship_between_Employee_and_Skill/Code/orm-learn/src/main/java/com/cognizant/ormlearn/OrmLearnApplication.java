package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private EmployeeService employeeService;
    private SkillService skillService;

    @Autowired
    public OrmLearnApplication(EmployeeService employeeService, SkillService skillService) {
        this.employeeService = employeeService;
        this.skillService = skillService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testAddSkillToEmployee();
    }

    private void testAddSkillToEmployee() {
        LOGGER.info("Start......");

        Employee employee = employeeService.get(105);
        Skill skill = skillService.get(3);

        List<Skill> skillList = employee.getSkillList();
        skillList.add(skill);
        employee.setSkillList(skillList);

        employeeService.save(employee);

        LOGGER.debug("Updated Employee Skills: {}", employee.getSkillList());
        LOGGER.info("End........");
    }
}