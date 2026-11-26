package com.cemcelik.service;

import com.cemcelik.dto.DtoAccountIU;
import com.cemcelik.dto.DtoCustomer;
import com.cemcelik.dto.DtoCustomerIU;

public interface ICustomerService {
	
	DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);

}
