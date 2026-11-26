package com.cemcelik.controller;

import com.cemcelik.dto.DtoAccount;
import com.cemcelik.dto.DtoAccountIU;

public interface IRestAccountController {
	
	public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);

}
