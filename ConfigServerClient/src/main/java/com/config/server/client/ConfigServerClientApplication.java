package com.config.server.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
@SpringBootApplication
public class ConfigServerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerClientApplication.class, args);
	}

	@Value("${hello.message}")
	private String message;

	@RequestMapping("/message")
	String getMessage() {
		return this.message;
	}
}
