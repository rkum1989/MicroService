package com.spring.cloud.consumer.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.spring.cloud.consumer.model.Employee;

@RequestMapping(value = "/consumer/service/api")
@RestController
public class EmployeeConsumerControllerClient {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadBalancer;

	@Autowired
	private AccountClient accountClient;

	public void getEmployee() throws RestClientException, IOException {

		// Using directly call by Hard coded URL
		/*
		 * String baseUrl = "http://localhost:9091/employee"; RestTemplate restTemplate
		 * = new RestTemplate(); ResponseEntity<String> response=null; try{
		 * response=restTemplate.exchange(baseUrl, HttpMethod.GET,
		 * getHeaders(),String.class); }catch (Exception ex) { System.out.println(ex); }
		 * System.out.println(response.getBody());
		 */

		// Using DiscoverClient API
		/*
		 * List<ServiceInstance>
		 * instances=discoveryClient.getInstances("EmployeeProducer"); ServiceInstance
		 * serviceInstance=instances.get(0);
		 * 
		 * String baseUrl=serviceInstance.getUri().toString();
		 */

		// Using LoadBalance (Netflix Ribbon)
		/*
		 * ServiceInstance serviceInstance=loadBalancer.choose("employee-producer");
		 * 
		 * System.out.println(serviceInstance.getUri());
		 * 
		 * String baseUrl=serviceInstance.getUri().toString();
		 * baseUrl=baseUrl+"/employee";
		 * 
		 * RestTemplate restTemplate = new RestTemplate(); ResponseEntity<String>
		 * response=null; try{ response=restTemplate.exchange(baseUrl, HttpMethod.GET,
		 * getHeaders(),String.class); }catch (Exception ex) { System.out.println(ex); }
		 * System.out.println(response.getBody());
		 */

	}

	@RequestMapping(value = "producer/employee", method=RequestMethod.GET)
	public Employee findEmployeeFromEmployeeProducer() {
		Employee employees = accountClient.getEmployee();
		return employees;
	}

	@RequestMapping(value = "producer/employees", method=RequestMethod.GET)
	public List<Employee> findEmployeesFromEmployeeProducer() {
		List<Employee> employees = accountClient.getEmployees();
		return employees;
	}
	
	@RequestMapping(value = "/consumerEmployee")
	public List<Employee> getEmployees() {
			
		List<Employee> employees = new ArrayList<Employee>();
		Employee emp = new Employee();
		emp.setName("Rituraj");
		emp.setDesignation("Developer");
		emp.setEmpId("1");
		emp.setSalary(3000);

		Employee emp2 = new Employee();
		emp2.setName("kumar");
		emp2.setDesignation("Senior manager");
		emp2.setEmpId("2");
		emp2.setSalary(30000);

		employees.add(emp);
		employees.add(emp2);

		return employees;
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}