package com.cemcelik.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.jwt.AuthResponse;
import com.cemcelik.jwt.JwtService;
import com.cemcelik.jwt.RefreshTokenRequest;
import com.cemcelik.model.RefreshToken;
import com.cemcelik.model.User;
import com.cemcelik.repository.RefreshTokenRepository;
import com.cemcelik.service.IRefreshTokenService;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	@Autowired
	private JwtService jwtService;

	public boolean isRefreshTokenExpired(Date expiredDate) {
		return new Date().after(expiredDate);
	}

	private RefreshToken createRefreshToken(User user) {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
		refreshToken.setUser(user);
		return refreshToken;
	}

	@Override
	public AuthResponse refreshToken(RefreshTokenRequest request) {
		Optional<RefreshToken> optional = refreshTokenRepository.findByRefreshToken(request.getRefreshToken());
		if (optional.isEmpty()) {
			System.out.println("Refresh Token'ınız geçersizdir." + request.getRefreshToken());
			return null;
		}
		RefreshToken refreshToken = optional.get();
		if (isRefreshTokenExpired(refreshToken.getExpiredDate())) {
			System.out.println("Refresh Token'ın süresi dolmuştur." + refreshToken.getRefreshToken());
			return null;
		}
		String accessToken = jwtService.generateToken(refreshToken.getUser());
		RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(refreshToken.getUser()));
		return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
	}

}
