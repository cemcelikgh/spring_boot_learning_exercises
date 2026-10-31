package com.cemcelik.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cemcelik.model.Employee;

@Configuration
public class AppConfig {

	@Bean
	public List<Employee> employeeList() {

		List<Employee> employeeList = new ArrayList<>();

		employeeList.add(new Employee("1", "Cem", "Çelik"));
		employeeList.add(new Employee("2", "Enes", "Bayram"));
		employeeList.add(new Employee("3", "Yakup", "Rençber"));
		employeeList.add(new Employee("4", "Bilal", "Çamur"));
		employeeList.add(new Employee("5", "Harun", "Yazıcı"));
		employeeList.add(new Employee("6", "Enes", "Yılmaz"));

		return employeeList;

	}

}
