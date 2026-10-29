package com.cemcelik.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cemcelik.model.User;
import com.cemcelik.services.UserService;

@Configuration
public class AppConfig {

	@Bean
	public UserService UserService() {

		UserService userService = new UserService();

		List<User> userList = new ArrayList<>();
		userList.add(new User("Cem"));
		userList.add(new User("Enes"));

		userService.setUserList(userList);

		return userService;

	}
}
