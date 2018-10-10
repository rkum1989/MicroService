package com.spring.cloud.consumer.controllers;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.cloud.consumer.model.Employee;

@FeignClient("EmployeeProducer")
interface AccountClient {

	@RequestMapping(method = RequestMethod.GET, value = "/producer/service/api/employee")
	Employee getEmployee();

	@RequestMapping(method = RequestMethod.GET, value = "/producer/service/api/employees")
	List<Employee> getEmployees();
}
