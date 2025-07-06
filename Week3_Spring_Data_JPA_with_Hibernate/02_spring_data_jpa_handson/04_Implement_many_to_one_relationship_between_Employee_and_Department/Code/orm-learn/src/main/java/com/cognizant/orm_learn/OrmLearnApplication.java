package com.cognizant.orm_learn;

import java.sql.Date;

import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.DepartmentService;
import com.cognizant.orm_learn.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static EmployeeService employeeService;
	private static DepartmentService departmentService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);

		testAddEmployeeFirstAndThenUpdate();
	}

	private static void testAddEmployeeFirstAndThenUpdate() {
		LOGGER.info("Start....");

		Employee employee = new Employee();
		employee.setId(5);
		employee.setName("Jane Smith");
		employee.setSalary(60000);
		employee.setPermanent(true);
		employee.setDateOfBirth(Date.valueOf("1993-08-21"));

		Department dept = departmentService.get(1);
		employee.setDepartment(dept);

		employeeService.save(employee);
		LOGGER.debug("Added Employee: {}", employee);

		LOGGER.info("Update Employee");
		Employee empToUpdate = employeeService.get(5);
		Department newDept = departmentService.get(2);
		empToUpdate.setDepartment(newDept);
		employeeService.save(empToUpdate);

		LOGGER.debug("Updated Employee: {}", empToUpdate);

		LOGGER.info("End....");
	}
}
