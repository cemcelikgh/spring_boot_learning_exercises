package com.cemcelik.controller;

import com.cemcelik.dto.DtoUser;
import com.cemcelik.jwt.AuthRequest;

public interface IRestAuthController {

	public DtoUser register(AuthRequest request);

}
