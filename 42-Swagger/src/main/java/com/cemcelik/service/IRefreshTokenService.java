package com.cemcelik.service;

import com.cemcelik.jwt.AuthResponse;
import com.cemcelik.jwt.RefreshTokenRequest;

public interface IRefreshTokenService {
	
	public AuthResponse refreshToken(RefreshTokenRequest request);

}
