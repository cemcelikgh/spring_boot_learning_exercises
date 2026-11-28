package com.cemcelik.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.CurrencyRatesResponse;
import com.cemcelik.dto.DtoCar;
import com.cemcelik.dto.DtoCustomer;
import com.cemcelik.dto.DtoGallerist;
import com.cemcelik.dto.DtoSoldCar;
import com.cemcelik.dto.DtoSoldCarIU;
import com.cemcelik.enums.CarStatusType;
import com.cemcelik.exception.BaseException;
import com.cemcelik.exception.ErrorMessage;
import com.cemcelik.exception.MessageType;
import com.cemcelik.model.Car;
import com.cemcelik.model.Customer;
import com.cemcelik.model.SaledCar;
import com.cemcelik.repository.CarRepository;
import com.cemcelik.repository.CustomerRepository;
import com.cemcelik.repository.GalleristRepository;
import com.cemcelik.repository.SoldCarRepository;
import com.cemcelik.service.ICurrencyRatesService;
import com.cemcelik.service.ISoldCarService;
//import com.cemcelik.utils.DateUtils;

@Service
public class SoldCarServiceImpl implements ISoldCarService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private GalleristRepository galleristRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private ICurrencyRatesService currencyRatesService;
	
	@Autowired
	private SoldCarRepository soldCarRepository;
	
	public boolean checkCarStatus(Long carId) {
		Optional<Car> optionalCar = carRepository.findById(carId);
		if (optionalCar.isPresent() && optionalCar.get().getCarStatusType().name().equals(CarStatusType.SALED.name())) {
			return false;
		}
		return true;
	}
	
	public BigDecimal converCustomerAmountToUsd(Customer customer) {
//		CurrencyRatesResponse currencyRatesResponse = currencyRatesService.getCurrencyRates(DateUtils.getCurrentDate(new Date()), DateUtils.getCurrentDate(new Date()));
		CurrencyRatesResponse currencyRatesResponse = currencyRatesService.getCurrencyRates("11-10-2024", "11-10-2024");
		BigDecimal usd = new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd());
		BigDecimal customerUsdAmount = customer.getAccount().getAmount().divide(usd, 2, RoundingMode.HALF_UP);
		return customerUsdAmount;
	}
	
	public BigDecimal remainingCustomerAmount(Customer customer, Car car) {
		BigDecimal customerUsdAmount = converCustomerAmountToUsd(customer);
		BigDecimal remainingCustomerUsdAmount = customerUsdAmount.subtract(car.getPrice());
//		CurrencyRatesResponse currencyRatesResponse = currencyRatesService.getCurrencyRates(DateUtils.getCurrentDate(new Date()), DateUtils.getCurrentDate(new Date()));
		CurrencyRatesResponse currencyRatesResponse = currencyRatesService.getCurrencyRates("11-10-2024", "11-10-2024");
		BigDecimal usd = new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd());
		return remainingCustomerUsdAmount.multiply(usd);
	}
	
	public boolean checkAmount(DtoSoldCarIU dtoSoldCarIU) {
		Optional<Customer> optionalCustomer = customerRepository.findById(dtoSoldCarIU.getCustomerId());
		if (optionalCustomer.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoSoldCarIU.getCustomerId().toString()));
		}
		Optional<Car> optionalCar = carRepository.findById(dtoSoldCarIU.getCarId());
		if (optionalCar.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoSoldCarIU.getCarId().toString()));
		}
		BigDecimal customerUsdAmount = converCustomerAmountToUsd(optionalCustomer.get());
		if (customerUsdAmount.compareTo(optionalCar.get().getPrice()) >= 0 ) {
			return true;
		}
		return false;
	}
	
	private SaledCar createSaledCar(DtoSoldCarIU dtoSoldCarIU) {
		SaledCar saledCar = new SaledCar();
		saledCar.setCreateTime(new Date());
		saledCar.setCustomer(customerRepository.findById(dtoSoldCarIU.getCustomerId()).orElse(null));
		saledCar.setGallerist(galleristRepository.findById(dtoSoldCarIU.getGallersitId()).orElse(null));
		saledCar.setCar(carRepository.findById(dtoSoldCarIU.getCarId()).orElse(null));
		return saledCar;
	}
	
	public DtoSoldCar convertSoldCarToDtoSoldCar(SaledCar soldCar) {
		DtoSoldCar dtoSoldCar = new DtoSoldCar();
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoGallerist dtoGallerist = new DtoGallerist();
		DtoCar dtoCar = new DtoCar();
		BeanUtils.copyProperties(soldCar, dtoSoldCar);
		BeanUtils.copyProperties(soldCar.getCustomer(), dtoCustomer);
		BeanUtils.copyProperties(soldCar.getGallerist(), dtoGallerist);
		BeanUtils.copyProperties(soldCar.getCar(), dtoCar);
		dtoSoldCar.setCustomer(dtoCustomer);
		dtoSoldCar.setGallersit(dtoGallerist);
		dtoSoldCar.setCar(dtoCar);
		return dtoSoldCar;		
	}

	@Override
	public DtoSoldCar buyCar(DtoSoldCarIU dtoSoldCarIU) {
		if (!checkCarStatus(dtoSoldCarIU.getCarId())) {
			throw new BaseException(new ErrorMessage(MessageType.CAR_STATUS_IS_ALREADY_SOLD, dtoSoldCarIU.toString()));
		}
		if (!checkAmount(dtoSoldCarIU)) {
			throw new BaseException(new ErrorMessage(MessageType.CUSTOMER_AMOUNT_IS_NOT_ENOUGHT, ""));
		}
		SaledCar savedSoldCar = soldCarRepository.save(createSaledCar(dtoSoldCarIU));
		Car car = savedSoldCar.getCar();
		car.setCarStatusType(CarStatusType.SALED);
		carRepository.save(car);
		Customer customer = savedSoldCar.getCustomer();
		customer.getAccount().setAmount(remainingCustomerAmount(customer, car));
		customerRepository.save(customer);
		return convertSoldCarToDtoSoldCar(savedSoldCar);
	}

}
