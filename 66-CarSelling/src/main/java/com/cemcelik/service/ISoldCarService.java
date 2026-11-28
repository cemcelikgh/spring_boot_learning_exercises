package com.cemcelik.service;

import com.cemcelik.dto.DtoSoldCar;
import com.cemcelik.dto.DtoSoldCarIU;

public interface ISoldCarService {
	
	public DtoSoldCar buyCar(DtoSoldCarIU dtoSoldCarIU);

}
