package com.cemcelik.service;

import com.cemcelik.dto.DtoCar;
import com.cemcelik.dto.DtoCarIU;

public interface ICarService {
	
	public DtoCar saveCar(DtoCarIU dtoCarIU);

}
