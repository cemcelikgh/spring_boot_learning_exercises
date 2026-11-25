package com.cemcelik.gallerist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.cemcelik" })
@EntityScan(basePackages = { "com.cemcelik" })
@EnableJpaRepositories(basePackages = { "com.cemcelik" })
@SpringBootApplication
public class GalleristApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalleristApplication.class, args);
	}

}
