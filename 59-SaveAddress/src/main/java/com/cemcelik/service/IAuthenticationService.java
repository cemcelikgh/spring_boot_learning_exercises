package com.cemcelik.service;

import com.cemcelik.dto.AuthRequest;
import com.cemcelik.dto.AuthResponse;
import com.cemcelik.dto.DtoUser;
import com.cemcelik.dto.RefreshTokenRequest;

public interface IAuthenticationService {
	
	public DtoUser register(AuthRequest input);
	
	public AuthResponse authenticate(AuthRequest input);
	
	public AuthResponse refreshToken(RefreshTokenRequest input);

}
