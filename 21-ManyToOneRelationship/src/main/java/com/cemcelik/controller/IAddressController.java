package com.cemcelik.controller;

import com.cemcelik.dto.DtoAddress;

public interface IAddressController {

	DtoAddress findAddressById(Long id);

}
