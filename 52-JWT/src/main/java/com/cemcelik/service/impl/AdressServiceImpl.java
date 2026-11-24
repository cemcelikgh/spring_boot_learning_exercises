package com.cemcelik.service.impl;

import org.springframework.stereotype.Service;

import com.cemcelik.exception.BaseException;
import com.cemcelik.exception.ErrorMessage;
import com.cemcelik.exception.MessageType;
import com.cemcelik.service.IAddressService;

@Service
public class AdressServiceImpl implements IAddressService {
	
	public void test() {
		throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, null));
	}

}
