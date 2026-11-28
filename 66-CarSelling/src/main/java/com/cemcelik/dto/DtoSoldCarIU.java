package com.cemcelik.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSoldCarIU {
	
	@NotNull
	private Long customerId;
	
	@NotNull
	private Long gallersitId;
	
	@NotNull
	private Long carId;

}
