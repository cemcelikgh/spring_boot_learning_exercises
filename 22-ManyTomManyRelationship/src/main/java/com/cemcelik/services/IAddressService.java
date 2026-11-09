package com.cemcelik.services;

import com.cemcelik.dto.DtoAddress;

public interface IAddressService {
	
	public DtoAddress findAddressById(Long id);

}
