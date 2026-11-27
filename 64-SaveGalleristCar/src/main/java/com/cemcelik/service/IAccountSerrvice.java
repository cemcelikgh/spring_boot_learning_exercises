package com.cemcelik.service;

import com.cemcelik.dto.DtoAccount;
import com.cemcelik.dto.DtoAccountIU;

public interface IAccountSerrvice {
	
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);

}
