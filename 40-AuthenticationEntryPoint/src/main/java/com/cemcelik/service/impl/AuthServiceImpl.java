package com.cemcelik.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoUser;
import com.cemcelik.jwt.AuthRequest;
import com.cemcelik.jwt.AuthResponse;
import com.cemcelik.jwt.JwtService;
import com.cemcelik.model.User;
import com.cemcelik.repository.UserRepository;
import com.cemcelik.service.IAuthService;

@Service
public class AuthServiceImpl implements IAuthService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtService jwtService;

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

	@Override
	public AuthResponse authenticate(AuthRequest request) {
		try {
			UsernamePasswordAuthenticationToken auth =
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
			authenticationProvider.authenticate(auth);
			Optional<User> optionalUser = userRepository.findByUsername(request.getUsername());
			String token = jwtService.generateToken(optionalUser.get());
			return new AuthResponse(token);
		} catch (Exception e) {
			System.out.println("Kullanıcı adı veya şifresi hatalı.");
		}
		return null;
	}

}
