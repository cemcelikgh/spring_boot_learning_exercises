package com.cemcelik.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoAddress;
import com.cemcelik.dto.DtoAddressIU;
import com.cemcelik.model.Address;
import com.cemcelik.repository.AddressRepository;
import com.cemcelik.service.IAddressService;

@Service
public class AdressServiceImpl implements IAddressService {

	@Autowired
	private AddressRepository addressRepository;

	private Address createAddress(DtoAddressIU dtoAddressIU) {
		Address address = new Address();
		address.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoAddressIU, address);
		return address;
	}

	@Override
	public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
		Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));
		DtoAddress dtoAddress = new DtoAddress();
		BeanUtils.copyProperties(savedAddress, dtoAddress);
		return dtoAddress;
	}

}
