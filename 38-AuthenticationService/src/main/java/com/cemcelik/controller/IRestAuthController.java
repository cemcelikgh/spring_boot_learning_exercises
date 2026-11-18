package com.cemcelik.controller;

import com.cemcelik.dto.DtoUser;
import com.cemcelik.jwt.AuthRequest;
import com.cemcelik.jwt.AuthResponse;

public interface IRestAuthController {

	public DtoUser register(AuthRequest request);
	
	public AuthResponse authenticate(AuthRequest request);

}
