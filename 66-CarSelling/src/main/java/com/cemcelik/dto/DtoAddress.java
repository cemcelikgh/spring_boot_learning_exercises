package com.cemcelik.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAddress extends DtoBase {
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String district;
	
	@NotEmpty
	private String neightborhood;
	
	@NotEmpty
	private String street;

}
