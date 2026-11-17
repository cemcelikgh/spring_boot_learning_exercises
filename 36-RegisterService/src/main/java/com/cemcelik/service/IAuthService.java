package com.cemcelik.service;

import com.cemcelik.dto.DtoUser;
import com.cemcelik.jwt.AuthRequest;

public interface IAuthService {

	public DtoUser register(AuthRequest request);

}
