package com.cemcelik.controller;

import com.cemcelik.dto.DtoAddress;
import com.cemcelik.dto.DtoAddressIU;

public interface IRestAddressController {
	
	public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);

}
