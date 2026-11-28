package com.cemcelik.controller;

import com.cemcelik.dto.DtoCar;
import com.cemcelik.dto.DtoCarIU;

public interface IRestCarController {
	
	public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);

}
