package com.cemcelik.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCustomer {
	
	private String firstName;

	private String lastName;

	private String tckn;

	private String birthOfDay;

	private DtoAddress address;

	private DtoAccount account;

}
