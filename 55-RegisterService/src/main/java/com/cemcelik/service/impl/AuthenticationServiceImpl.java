package com.cemcelik.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.AuthRequest;
import com.cemcelik.dto.DtoUser;
import com.cemcelik.model.User;
import com.cemcelik.repository.UserRepository;
import com.cemcelik.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private User createUser(AuthRequest input) {
		User user = new User();
		user.setCreateTime(new Date());
		user.setUsername(input.getUsername());
		user.setPassword(passwordEncoder.encode(input.getPassword()));
		return user;
	}

	@Override
	public DtoUser register(AuthRequest input) {
		DtoUser dtoUser = new DtoUser();
		User savedUser = userRepository.save(createUser(input));
		BeanUtils.copyProperties(savedUser, dtoUser);
		return dtoUser;
	}

}
