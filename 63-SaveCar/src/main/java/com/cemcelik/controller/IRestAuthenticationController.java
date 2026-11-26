package com.cemcelik.controller;

import com.cemcelik.dto.AuthRequest;
import com.cemcelik.dto.AuthResponse;
import com.cemcelik.dto.DtoUser;
import com.cemcelik.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {
	
	public RootEntity<DtoUser> register(AuthRequest input);
	
	public RootEntity<AuthResponse> authenticate(AuthRequest input);
	
	public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);

}
