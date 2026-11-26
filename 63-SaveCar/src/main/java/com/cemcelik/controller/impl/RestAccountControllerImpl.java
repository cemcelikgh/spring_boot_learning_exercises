package com.cemcelik.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cemcelik.controller.IRestAccountController;
import com.cemcelik.controller.RestBaseController;
import com.cemcelik.controller.RootEntity;
import com.cemcelik.dto.DtoAccount;
import com.cemcelik.dto.DtoAccountIU;
import com.cemcelik.service.IAccountSerrvice;

@RestController
@RequestMapping("/rest/api/account")
public class RestAccountControllerImpl extends RestBaseController implements IRestAccountController {

	@Autowired
	private IAccountSerrvice accountSerrvice;

	@Override
	public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU) {
		return ok(accountSerrvice.saveAccount(dtoAccountIU));
	}

}
