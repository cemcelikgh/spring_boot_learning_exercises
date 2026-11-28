package com.cemcelik.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cemcelik.controller.IRestCurrencyRatesController;
import com.cemcelik.controller.RestBaseController;
import com.cemcelik.controller.RootEntity;
import com.cemcelik.dto.CurrencyRatesResponse;
import com.cemcelik.service.ICurrencyRatesService;

@RestController
@RequestMapping("/rest/api")
public class RestCurrencyRatesControllerImpl extends RestBaseController implements IRestCurrencyRatesController {
	
	@Autowired
	private ICurrencyRatesService currencyRatesService;

	@GetMapping("/currency-rates")
	@Override
	public RootEntity<CurrencyRatesResponse> getCurrencyRates(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
		return ok(currencyRatesService.getCurrencyRates(startDate, endDate));
	}

}
