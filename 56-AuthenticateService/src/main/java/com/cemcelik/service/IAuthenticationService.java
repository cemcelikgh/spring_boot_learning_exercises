package com.cemcelik.service;

import com.cemcelik.dto.AuthRequest;
import com.cemcelik.dto.AuthResponse;
import com.cemcelik.dto.DtoUser;

public interface IAuthenticationService {
	
	public DtoUser register(AuthRequest input);
	
	public AuthResponse authenticate(AuthRequest input);

}
