package com.cemcelik.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoAddress;
import com.cemcelik.dto.DtoCustomer;
import com.cemcelik.entities.Address;
import com.cemcelik.entities.Customer;
import com.cemcelik.repository.CustomerRepository;
import com.cemcelik.services.ICustomerService;

@Service
public class CustomerServiceUmpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public DtoCustomer findCustomerById(Long id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Customer customer = optional.get();
		Address address = customer.getAddress();
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		BeanUtils.copyProperties(customer, dtoCustomer);
		BeanUtils.copyProperties(address, dtoAddress);
		dtoCustomer.setAddress(dtoAddress);
		return dtoCustomer;
	}

}