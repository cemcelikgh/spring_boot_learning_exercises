package com.cemcelik.service;

import com.cemcelik.dto.CurrencyRatesResponse;

public interface ICurrencyRatesService {
	
	public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate);

}
