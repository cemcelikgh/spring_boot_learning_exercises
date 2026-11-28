package com.cemcelik.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoAccount;
import com.cemcelik.dto.DtoAddress;
import com.cemcelik.dto.DtoCustomer;
import com.cemcelik.dto.DtoCustomerIU;
import com.cemcelik.exception.BaseException;
import com.cemcelik.exception.ErrorMessage;
import com.cemcelik.exception.MessageType;
import com.cemcelik.model.Account;
import com.cemcelik.model.Address;
import com.cemcelik.model.Customer;
import com.cemcelik.repository.AccountRepository;
import com.cemcelik.repository.AddressRepository;
import com.cemcelik.repository.CustomerRepository;
import com.cemcelik.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
		Optional<Address> optionalAddress = addressRepository.findById(dtoCustomerIU.getAccountId());
		if (optionalAddress.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAddressId().toString()));
		}
		Optional<Account> optionalAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
		if (optionalAccount.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAccountId().toString()));
		}
		Customer customer = new Customer();
		customer.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoCustomerIU, customer);
		customer.setAccount(optionalAccount.get());
		customer.setAddress(optionalAddress.get());
		return customer;
	}

	@Override
	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
		DtoCustomer dtoCustomer = new DtoCustomer();
		Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));
		BeanUtils.copyProperties(savedCustomer, dtoCustomer);
		DtoAddress dtoAddress = new DtoAddress();
		BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
		DtoAccount dtoAccount = new DtoAccount();
		BeanUtils.copyProperties(savedCustomer, dtoAccount);
		dtoCustomer.setAddress(dtoAddress);
		dtoCustomer.setAccount(dtoAccount);
		return dtoCustomer;
	}


}
