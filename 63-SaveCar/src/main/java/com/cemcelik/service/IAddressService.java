package com.cemcelik.service;

import com.cemcelik.dto.DtoAddress;
import com.cemcelik.dto.DtoAddressIU;

public interface IAddressService {
	
	public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);

}
