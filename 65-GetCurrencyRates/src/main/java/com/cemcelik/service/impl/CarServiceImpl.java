package com.cemcelik.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoCar;
import com.cemcelik.dto.DtoCarIU;
import com.cemcelik.model.Car;
import com.cemcelik.repository.CarRepository;
import com.cemcelik.service.ICarService;

@Service
public class CarServiceImpl implements ICarService {
	
	@Autowired
	private CarRepository carRepository;
	
	private Car createCar(DtoCarIU dtoCarIU) {
		Car car = new Car();
		car.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoCarIU, car);
		return car;
	}

	@Override
	public DtoCar saveCar(DtoCarIU dtoCarIU) {
		Car savedCar = carRepository.save(createCar(dtoCarIU));
		DtoCar dtoCar = new DtoCar();
		BeanUtils.copyProperties(savedCar, dtoCar);
		return dtoCar;
	}

}
