package com.cemcelik.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoAccount;
import com.cemcelik.dto.DtoAccountIU;
import com.cemcelik.model.Account;
import com.cemcelik.repository.AccountRepository;
import com.cemcelik.service.IAccountSerrvice;

@Service
public class AccountServiceImpl implements IAccountSerrvice {
	
	@Autowired
	private AccountRepository accountRepository;
	
	private Account createAccount(DtoAccountIU dtoAccountIU) {
		Account account = new Account();
		account.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoAccountIU, account);
		return account;
	}

	@Override
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
		Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));
		DtoAccount dtoAccount = new DtoAccount();
		BeanUtils.copyProperties(savedAccount, dtoAccount);
		return dtoAccount;
	}

}
