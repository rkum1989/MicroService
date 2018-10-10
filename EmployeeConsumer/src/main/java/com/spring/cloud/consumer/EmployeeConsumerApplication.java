package com.spring.cloud.consumer;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.spring.cloud.consumer.controllers.EmployeeConsumerControllerClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EmployeeConsumerApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		
		SpringApplication.run(EmployeeConsumerApplication.class, args);
		//ApplicationContext ctx = SpringApplication.run(
				//SpringBootHelloWorldApplication.class, args);
		
		//ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
		//System.out.println(consumerControllerClient);
		//consumerControllerClient.getEmployee();
		
	}
	
	/*@Bean
	public  ConsumerControllerClient  consumerControllerClient()
	{
		return  new ConsumerControllerClient();
	}*/
}