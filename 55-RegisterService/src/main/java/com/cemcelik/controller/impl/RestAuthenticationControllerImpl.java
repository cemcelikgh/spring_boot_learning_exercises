package com.cemcelik.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cemcelik.controller.IRestAuthenticationController;
import com.cemcelik.controller.RestBaseController;
import com.cemcelik.controller.RootEntity;
import com.cemcelik.dto.AuthRequest;
import com.cemcelik.dto.DtoUser;
import com.cemcelik.service.IAuthenticationService;

import jakarta.validation.Valid;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {
	
	@Autowired
	private IAuthenticationService authenticationService;

	@PostMapping("/register")
	@Override
	public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {
		return ok(authenticationService.register(input));
	}

}
