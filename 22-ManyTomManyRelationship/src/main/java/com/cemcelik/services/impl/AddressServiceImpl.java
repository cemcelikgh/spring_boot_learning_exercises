package com.cemcelik.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoAddress;
import com.cemcelik.dto.DtoCustomer;
import com.cemcelik.entities.Address;
import com.cemcelik.repository.AddressRepository;
import com.cemcelik.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public DtoAddress findAddressById(Long id) {
		Optional<Address> optional = addressRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Address address = optional.get();
		DtoAddress dtoAddress = new DtoAddress();
		BeanUtils.copyProperties(address, dtoAddress);
		DtoCustomer dtoCustomer = new DtoCustomer();
		dtoCustomer.setId(address.getCustomer().getId());
		dtoCustomer.setName(address.getCustomer().getName());
		dtoAddress.setCustomer(dtoCustomer);
		return dtoAddress;
	}

}
