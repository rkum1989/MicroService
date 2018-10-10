package com.spring.cloud.producer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.producer.model.Employee;
@RequestMapping(value = "/producer/service/api")
@RestController
public class EmployeeProducerController {
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee getEmployeeCalledByFeignClient() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		return emp;
	}	
	
	@RequestMapping(value = "/employees" , method =RequestMethod.GET)
	public List<Employee> findById() {
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(1000);
		
		Employee emp2 = new Employee();
		emp2.setName("emp2");
		emp2.setDesignation("Senior manager");
		emp2.setEmpId("2");
		emp2.setSalary(2000);
		
		employees.add(emp);
		employees.add(emp2);
		
		return employees;
	}
}
