package com.cemcelik.controller;

import com.cemcelik.dto.DtoCustomer;

public interface ICustomerController {

	public DtoCustomer findCustomerById(Long id);

}
