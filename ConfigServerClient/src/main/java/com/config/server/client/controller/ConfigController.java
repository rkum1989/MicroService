package com.config.server.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/config/service/api")
@RestController
public class ConfigController {

	@Value("${eureka.client.serviceUrl.defaultZone}")
	private String configDate;

	@RequestMapping(value = "/data", method=RequestMethod.GET)
	public String findEmployeeFromEmployeeProducer() {
		
		return configDate;
	}
	
}