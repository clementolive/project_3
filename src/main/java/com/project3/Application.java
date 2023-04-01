package com.project3;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/** @author Clément Olive
 * This API completes the Angular frontend from project 3 in Openclassrooms course.
 * Some changes were needed in architecture because some functions and libraries have been deprecated since the course
 * (Like WebConfigurerAdapter) */
@OpenAPIDefinition
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
