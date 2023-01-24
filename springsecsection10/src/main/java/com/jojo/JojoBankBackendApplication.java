package com.jojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class JojoBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JojoBankBackendApplication.class, args);
	}

}
