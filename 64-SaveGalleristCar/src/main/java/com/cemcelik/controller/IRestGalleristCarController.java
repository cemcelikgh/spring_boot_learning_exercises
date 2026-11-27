package com.cemcelik.controller;

import com.cemcelik.dto.DtoGalleristCar;
import com.cemcelik.dto.DtoGalleristCarIU;

public interface IRestGalleristCarController {
	
	public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);

}
