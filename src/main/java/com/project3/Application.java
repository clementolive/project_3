package com.project3;

import com.project3.services.FilesStorageService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

/** @author Clément Olive
 * This API completes the Angular frontend from project 3 in Openclassrooms course.
 * Some changes were needed in architecture because some functions and libraries have been deprecated since the course
 * (Like WebConfigurerAdapter) */
@OpenAPIDefinition
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Application {

	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(FilesStorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
