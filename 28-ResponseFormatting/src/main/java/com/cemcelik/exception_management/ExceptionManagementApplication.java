package com.cemcelik.exception_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = { "com.cemcelik" })
@EnableJpaRepositories(basePackages = { "com.cemcelik" })
@ComponentScan(basePackages = { "com.cemcelik" })
@SpringBootApplication
public class ExceptionManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionManagementApplication.class, args);
	}

}
