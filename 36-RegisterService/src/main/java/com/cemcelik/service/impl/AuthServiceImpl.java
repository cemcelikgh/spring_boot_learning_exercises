package com.cemcelik.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoUser;
import com.cemcelik.jwt.AuthRequest;
import com.cemcelik.model.User;
import com.cemcelik.repository.UserRepository;
import com.cemcelik.service.IAuthService;

@Service
public class AuthServiceImpl implements IAuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public DtoUser register(AuthRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		User savedUser = userRepository.save(user);
		DtoUser dtoUser = new DtoUser();
		BeanUtils.copyProperties(savedUser, dtoUser);
		return dtoUser;
	}

}
