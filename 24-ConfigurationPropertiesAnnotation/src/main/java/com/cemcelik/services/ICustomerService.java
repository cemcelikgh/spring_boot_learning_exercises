package com.cemcelik.services;

import com.cemcelik.dto.DtoCustomer;
import com.cemcelik.repository.CustomerRepository;

public interface ICustomerService {

	public DtoCustomer findCustomerById(Long id);

}
