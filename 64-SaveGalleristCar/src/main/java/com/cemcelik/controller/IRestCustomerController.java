package com.cemcelik.controller;

import com.cemcelik.dto.DtoCustomer;
import com.cemcelik.dto.DtoCustomerIU;

public interface IRestCustomerController {
	
	public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);

}
