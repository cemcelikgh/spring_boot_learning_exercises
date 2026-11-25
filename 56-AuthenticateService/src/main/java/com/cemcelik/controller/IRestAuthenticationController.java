package com.cemcelik.controller;

import com.cemcelik.dto.AuthRequest;
import com.cemcelik.dto.AuthResponse;
import com.cemcelik.dto.DtoUser;

public interface IRestAuthenticationController {
	
	public RootEntity<DtoUser> register(AuthRequest input);
	
	public RootEntity<AuthResponse> authenticate(AuthRequest input);

}
