package com.cemcelik.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cemcelik.model.RefreshToken;
import java.util.List;


public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
	
	Optional<RefreshToken> findByRefreshToken(String refreshToken);

}
